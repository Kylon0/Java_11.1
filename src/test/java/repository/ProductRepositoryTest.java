package repository;

import domain.*;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(2, "Книга", 2000, "Толстой");
    private Smartphone second = new Smartphone(3, "Phone", 1500, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
    }

    @Test
    void searchBookByName() {
        Product[] actual = manager.searchBy("Книга");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchSmartphoneByName() {
        Product[] actual = manager.searchBy("Phone");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByAuthor() {
        Product[] actual = manager.searchBy("Толстой");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected,actual);
    }

    @Test
    void searchSmartphoneByManufacturer() {
        Product[] actual = manager.searchBy("Apple");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected,actual);
    }
}