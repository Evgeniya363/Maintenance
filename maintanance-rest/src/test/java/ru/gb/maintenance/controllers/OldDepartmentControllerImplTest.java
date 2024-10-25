package ru.gb.maintenance.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.maintenance.model.Department;
import ru.gb.maintenance.model.dtos.DepartmentDto;
import ru.gb.maintenance.repositories.CompanyRepository;
import ru.gb.maintenance.repositories.DepartmentRepository;
import ru.gb.maintenance.testService.DepartmentTestDataCreator;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class OldDepartmentControllerImplTest {

    @Autowired
    DepartmentTestDataCreator creator;

    @Autowired
    WebTestClient webTestClient;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    DepartmentRepository departmentRepository;

//    ThreadLocalRandom random = ThreadLocalRandom.current();

    @BeforeEach
    void beforeEachAction() {
        deleteAllDate();
    }

    private void deleteAllDate() {
        companyRepository.deleteAll();
        departmentRepository.deleteAll();
    }

    @Test
    void testGetByIdAllOk() {
        // given
        DepartmentDto expected = creator.createDto(creator.create());

        // when, then
        webTestClient.get()
                .uri("/departments/" + expected.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(DepartmentDto.class)
                .isEqualTo(expected);

    }

    @Test
    void testGetByIdNotFound() {

        webTestClient.get()
                .uri("/departments/-2")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }

    @Test
    void testGetAll() {
        //given
        java.util.List<DepartmentDto> departments = creator.createListDto();

        // when, then
        webTestClient.get()
                .uri("/departments")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(DepartmentDto.class)
                .hasSize(departments.size())
                .consumeWith(result -> {
                    java.util.List<DepartmentDto> responseBody = result.getResponseBody();
                    assertNotNull(responseBody);

                    for (int i = 0; i < responseBody.size(); i++) {
                        DepartmentDto actual = responseBody.get(i);
                        DepartmentDto expected = departments.get(i);
                        assertEquals(actual, expected);
                    }

                });

    }

    @Test
    void testDeleteById() {
        Department department = creator.create();

        webTestClient.delete()
                .uri("/departments/" + department.getId())
                .exchange()
                .expectStatus().isNoContent();

        assertFalse(departmentRepository.existsById(department.getId()));

    }

    @Test
    void testUpdateById() {

        DepartmentDto expected = creator.createDto(creator.create());

        webTestClient.put()
                .uri("/departments/" + expected.getId())
                .bodyValue(expected)
                .exchange()
                .expectStatus().isOk()
                .expectBody(DepartmentDto.class)
                .isEqualTo(expected);

        Department actual = departmentRepository.findById(expected.getId())
                .orElseThrow(() -> new NoSuchElementException("Не найден элемент"));

        assertEquals(expected, creator.createDto(actual));

    }

    @Test
    void testCreate() {

        DepartmentDto department = creator.createDto();

        webTestClient.post()
                .uri("/departments")
                .bodyValue(department)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(DepartmentDto.class)
                .isEqualTo(department);  // Аннотация @Data включает @@EqualsAndHashCode

        assertTrue(departmentRepository.existsById(department.getId()));

    }


}