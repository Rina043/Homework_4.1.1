package ru.netology.domain;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "A Song of Ice and Fire", 1000, "George Martin");

    @Test
    public void shouldCompareNameIfExist(){
        String text = "A Song of Ice and Fire";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldCompareNameIfNotExist(){
        String text = "Game of Thrones";
        assertFalse(book.matches(text));
    }

    @Test
    public void shouldCompareAuthorIfExist(){
        String text = "George Martin";
        assertTrue(book.matches(text));
    }

    @Test
    public void shouldCompareAuthorIfNotExist(){
        String text = "Conan Doyle";
        assertFalse(book.matches(text));
    }


}