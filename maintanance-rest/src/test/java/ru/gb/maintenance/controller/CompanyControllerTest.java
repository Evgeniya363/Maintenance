package ru.gb.maintenance.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.maintenance.model.Company;
import ru.gb.maintenance.repositiry.CompanyRepository;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CompanyControllerTest {

    @Autowired
    CompanyRepository repository;

    @Autowired
    WebTestClient webTestClient;

    @BeforeEach
    void testDeleteAll() {
        repository.deleteAll();
    }

    @Test
    void testFindByIdAllOk() {
        // given
        Company expected = createCompany();
        // when, then
        webTestClient.get()
                .uri("/companies/" + expected.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Company.class)
                .value(actual -> {
                    assertNotNull(actual);
                    assertEquals(expected.getId(), actual.getId());
                    assertEquals(expected.getName(), actual.getName());
                });

    }

    @Test
    void testGetByIdNotFound() {

        webTestClient.get()
                .uri("/companies/-2")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }

    @Test
    void testGetAll() {
        //given
        java.util.List<Company> timesheets = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            timesheets.add(createCompany());
        }
        // when
        webTestClient.get()
                .uri("/companies")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Company.class)
                // then
                .hasSize(timesheets.size())
                .consumeWith(result -> {
                    java.util.List<Company> responseBody = result.getResponseBody();
                    assertNotNull(responseBody);

                    for (int i = 0; i < responseBody.size(); i++) {
                        Company actual = responseBody.get(i);
                        Company expected = timesheets.get(i);
                        assertNotNull(actual);
                        assertEquals(actual, expected);  // Аннотация @Data включает @@EqualsAndHashCode
                    }

                });

    }

    @Test
    void testCreate() {

        Company company = createCompany();
        webTestClient.post()
                .uri("/companies")
                .bodyValue(company)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Company.class)
                .isEqualTo(company);  // Аннотация @Data включает @@EqualsAndHashCode

        assertTrue(repository.existsById(company.getId()));

    }

    @Test
    void testUpdate() {

        Company company = createCompany();
        company.setName("Company#"+ThreadLocalRandom.current().nextInt(100));
        Company expected = repository.save(company);

        webTestClient.put()
                .uri("/companies/" + company.getId())
                .bodyValue(expected)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Company.class)
                .isEqualTo(expected);

        Company actual = repository.findById(expected.getId())
                .orElseThrow(() -> new NoSuchElementException("Не найден элемент"));

        assertEquals(expected, actual);

    }

    @Test
    void testDeleteById() {
        Company company = createCompany();

        webTestClient.delete()
                .uri("/companies/" + company.getId())
                .exchange()
                .expectStatus().isNoContent();

        assertFalse(repository.existsById(company.getId()));

    }

    private Company createCompany() {
        ThreadLocalRandom random = ThreadLocalRandom.current();

        Company company = new Company();
        company.setName("Company#" + random.nextLong(1, 100L));

        return repository.save(company);
    }


}