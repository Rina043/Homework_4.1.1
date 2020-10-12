package ru.netology.manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager productManager = new ProductManager(repository);
    private Book first = new Book(1, "name1", 1000, "author1");
    private Book second = new Book(2, "name2", 2000, "author2");
    private Smartphone apple = new Smartphone(3, "Iphone", 10000, "Apple");
    private Smartphone xiaomi = new Smartphone(4, "New", 20000, "Xiaomi");

    @BeforeEach
    public void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(apple);
        productManager.add(xiaomi);
    }

    @Test
    void shouldFindBookByNameIfExists() {
        String textToFind = "name2";
        Product[] expected = new Product[]{second};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookByAuthorIfExists() {
        String textToFind = "author1";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{first};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByNameIfNotExists() {
        String textToFind = "name3";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBookByAuthorIfNotExists() {
        String textToFind = "author3";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartByNameIfExists() {
        String textToFind = "Iphone";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{apple};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartByProducerIfExists() {
        String textToFind = "Xiaomi";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{xiaomi};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartByNameIfNotExists() {
        String textToFind = "Galaxy";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartByProducerIfNotExists() {
        String textToFind = "Samsung";
        productManager.searchBy(textToFind);
        Product[] expected = new Product[]{};
        Product[] actual = productManager.searchBy(textToFind);
        assertArrayEquals(expected, actual);
    }

}