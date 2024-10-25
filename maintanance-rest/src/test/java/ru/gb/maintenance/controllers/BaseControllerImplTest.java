package ru.gb.maintenance.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import ru.gb.maintenance.model.BaseEntity;
import ru.gb.maintenance.model.dtos.BaseDto;
import ru.gb.maintenance.model.maps.BaseMapper;
import ru.gb.maintenance.repositories.BaseEntityRepository;
import ru.gb.maintenance.testService.BaseTestDataCreator;
import ru.gb.maintenance.testService.PojoToJsonConvertor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
abstract class BaseControllerImplTest<T extends BaseEntity, D extends BaseDto, M extends BaseMapper<T,D>, C extends  BaseTestDataCreator<T, D, M>> {

    protected String uri = "/companies";

    @Autowired
    protected WebTestClient webTestClient;


    @Autowired
    protected BaseEntityRepository<T> repository;

    @Autowired
    protected C creator;

    @Autowired
    protected PojoToJsonConvertor<D> convertor;

    @BeforeEach
    void beforeEachAction() {
        deleteAllData();
    }

    private void deleteAllData() {
        repository.deleteAll();
    }

    @Test
    void testGetByIdAllOk() {
        // given
        T t = creator.create();
        D expected = creator.createDto(t);

        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
        Type type = superClass.getActualTypeArguments()[1].getClass();

        // when, then <B> WebTestClient.BodySpec<B,?> ожидает тело(Класс<B> тип тела)
        webTestClient.get()
                .uri(uri + "/" + expected.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(convertor.PojoToJson(expected));

    }

    @Test
    void testGetByIdNotFound() {

        webTestClient.get()
                .uri(uri + "/-2")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(Void.class);
    }

    @Test
    void testGetAll() {
        //given
        java.util.List<D> expected = creator.createListDto();

        // when, then
        webTestClient.get()
                .uri(uri)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(convertor.PojoListToJson(expected));

        // TODO Не удалять!!!
//        webTestClient.get()
//                .uri(uri)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBodyList(String.class)
//                .hasSize(departments.size())
//                .consumeWith(result -> {
//                    //java.testService.List<D> responseBody = result.getResponseBody();
//                    java.testService.List<String> responseBody = result.getResponseBody();
//                    assertNotNull(responseBody);
//
//                    for (int i = 0; i < responseBody.size(); i++) {
//                        //DepartmentDto actual = responseBody.get(i);
//                        //DepartmentDto expected = departments.get(i);
//                        String actual = responseBody.get(i);
//                        String expected = departments.get(i).toString();
//                        assertEquals(actual, expected);
//                    }
//
//                });

    }

    @Test
    void testDeleteById() {
        T t = creator.create();

        webTestClient.delete()
                .uri(uri + "/" + t.getId())
                .exchange()
                .expectStatus().isNoContent();

        assertFalse(repository.existsById(t.getId()));

    }

    @Test
    void testUpdateById() {
        T t = creator.create();
        D expected = creator.createDto();
        expected.setId(t.getId());

        webTestClient.put()
                .uri(uri + "/" + expected.getId())
                .bodyValue(expected)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo(convertor.PojoToJson(expected));

        T actual = repository.findById(expected.getId())
                .orElseThrow(() -> new NoSuchElementException("Не найден элемент"));

        assertEquals(creator.createDto(actual), expected);

    }

    @Test
    void testCreate() {

        D expected = creator.createDto();

        webTestClient.post()
                .uri(uri)
                .bodyValue(expected)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(String.class)
                .isEqualTo(convertor.PojoToJson(expected));

        assertTrue(repository.existsById(expected.getId()));

    }


}