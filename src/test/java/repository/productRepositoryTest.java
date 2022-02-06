package repository;

import domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class productRepositoryTest {

    @Test
    void search() {
        productRepository repo = new productRepository();
        book first = new book();
        first.setId(1);
        first.setAuthor("Толстой");
        first.setTitle("Война и Мир");
        first.setName("Книга Война и Мир");
        first.setPrice(1000);
        repo.save(first);
        repo.findAll();
        productManager manager = new productManager(repo);
        manager.searchBy("Толстой");
        boolean actual = manager.matches(first,"Толстой");
        boolean expected = true;
        assertEquals(expected,actual);
    }
}