package repository;

import domain.*;
import manager.ProductManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    @Test
    void search() {
        ProductRepository repo = new ProductRepository();
        Book first = new Book();
        first.setId(1);
        first.setAuthor("Толстой");
        first.setName("Книга Война и Мир");
        first.setPrice(1000);
        repo.save(first);
        repo.findAll();
        ProductManager manager = new ProductManager(repo);

        boolean actual = manager.matches(first,"Толстой");
        boolean expected = true;
        assertEquals(expected,actual);
    }
    @Test
    void search2() {
        ProductRepository repo = new ProductRepository();
        Book first = new Book();
        first.setId(1);
        first.setAuthor("Толстой");
        first.setName("Книга Война и Мир");
        first.setPrice(1000);
        repo.save(first);
        repo.findAll();
        ProductManager manager = new ProductManager(repo);

        boolean actual = manager.matches(first,"Достоевский");
        boolean expected = false;
        assertEquals(expected,actual);
    }
}