package com.skillbox.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FibonacciRepositoryTest extends PostgresTestContainerInitializer {

    @Autowired
    FibonacciRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    EntityManager entityManager;

    @Test
    void testSaveFibonacciNumberToDatabase() {
        FibonacciNumber number = new FibonacciNumber(1, 1);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        List<FibonacciNumber> actual = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 1",
                (rs, rowNum) -> new FibonacciNumber(
                        rs.getInt("index"),
                        rs.getInt("value"))
        );

        assertEquals(1, actual.size());
        assertEquals(number.getIndex(), actual.get(0).getIndex());
        assertEquals(number.getValue(), actual.get(0).getValue());
    }

    @Test
    void testFindByIndexReturnsCorrectValue() {
        FibonacciNumber number = new FibonacciNumber(5, 5);
        repository.save(number);
        entityManager.flush();
        entityManager.detach(number);

        FibonacciNumber found = repository.findByIndex(5).orElse(null);

        assertNotNull(found);
        assertEquals(5, found.getIndex());
        assertEquals(5, found.getValue());
    }

    @Test
    void testDuplicateInsertDoesNotCreateDuplicates() {
        FibonacciNumber number1 = new FibonacciNumber(10, 55);
        repository.save(number1);
        entityManager.flush();
        entityManager.detach(number1); // важно!

        FibonacciNumber number2 = new FibonacciNumber(10, 55); // та же index
        repository.save(number2);
        entityManager.flush();
        entityManager.detach(number2); // можно и тут, чтобы избежать последствий в будущем

        List<FibonacciNumber> results = jdbcTemplate.query(
                "SELECT * FROM fibonacci_number WHERE index = 10",
                (rs, rowNum) -> new FibonacciNumber(
                        rs.getInt("index"),
                        rs.getInt("value"))
        );

        assertEquals(1, results.size());
        assertEquals(10, results.get(0).getIndex());
        assertEquals(55, results.get(0).getValue());
    }
}