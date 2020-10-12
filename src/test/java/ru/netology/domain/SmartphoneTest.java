package ru.netology.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "Iphone", 20000, "Apple");

    @Test
    void shouldMatchByNameIfExists() {
        String textToFind = "Iphone";
        smartphone.matches(textToFind);
        assertTrue(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByNameIfNotExists() {
        String textToFind = "Galaxy";
        smartphone.matches(textToFind);
        assertFalse(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByProducerIfExists() {
        String textToFind = "Apple";
        smartphone.matches(textToFind);
        assertTrue(smartphone.matches(textToFind));
    }

    @Test
    void shouldMatchByProducerIfNotExists() {
        String textToFind = "Samsung";
        smartphone.matches(textToFind);
        assertFalse(smartphone.matches(textToFind));
    }

}