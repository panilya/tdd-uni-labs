package com.example.lab4.repository;

import com.example.lab4.model.Entity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataMongoTest
class EntityRepositoryTest {

    @Autowired
    EntityRepository entityRepository;

    @BeforeEach
    void setUp() {
        List<Entity> items = List.of(
                new Entity("1", "Illia", "TBD", LocalDateTime.now(), null),
                new Entity("2", "Kolya", "TBD", LocalDateTime.now(), null),
                new Entity("3", "Sasha", "TBD", LocalDateTime.now(), null)
        );
        entityRepository.saveAll(items);
    }

    @AfterEach
    void tearDown() {
        List<Entity> entities = entityRepository.findAll()
                .stream()
                .filter(item -> item.getDescription().contains("TBD"))
                .toList();
        entityRepository.deleteAll(entities);
    }

    @Test
    void itShouldCheckThrCollectionIsNotEmpty() {
        assertFalse(entityRepository.findAll().isEmpty());
        List<Entity> entities = entityRepository.findAll()
                .stream()
                .filter(item -> item.getDescription().contains("TBD"))
                .toList();
        assertEquals(entities.size(), 3);
    }

    @Test
    void itShouldSaveEntity() {
        Entity testEntity = new Entity("user_1", "Local description");
        entityRepository.save(testEntity);
        Entity forTest = entityRepository.findAll()
                .stream()
                .filter(item -> item.getName().equals("user_1"))
                .filter(item -> item.getDescription().contains("Local description"))
                .findAny()
                .orElse(null);
        assertNotNull(forTest);
        assertNotNull(forTest.getId());
        assertFalse(forTest.getId().isEmpty());
        assertEquals(forTest.getDescription(), "Local description");
        entityRepository.delete(testEntity);
    }

    @Test
    void itShouldUpdateEntity() {
        Entity testEntity = new Entity("123", "Illia", "new description", LocalDateTime.now(), LocalDateTime.now());
        entityRepository.save(testEntity);
        Entity forTest = entityRepository.getEntityById("123");
        assertNotNull(forTest.getId());
        assertFalse(forTest.getId().isEmpty());
        assertEquals(forTest.getName(), "Illia");
        assertEquals(forTest.getDescription(), "new description");
    }

    @Test
    void itShouldDeleteEntity() {
        Entity testEntity = new Entity("51", "Illia", "To be deleted", LocalDateTime.now(), null);
        entityRepository.delete(testEntity);
        Entity forTest = entityRepository.getEntityById("51");
        assertNull(forTest);
    }
}
