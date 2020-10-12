package ru.netology.domain;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product one = new Product(1, "name1", 1000);


    @Test
    public void shouldCompareNameIfExist(){
        String text = "name1";
        assertTrue(one.matches(text));
    }

    @Test
    public void shouldCompareNameIfNotExist(){
        String text = "name2";
        assertFalse(one.matches(text));
    }


}