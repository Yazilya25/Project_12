package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();
    Product book1 = new Book (111,"Pride and Prejudice", 555, "Jane Austen");
    Product book2 = new Book(122, "Jane Eyre", 444, "Charlotte Bronte");
    Product smartphone1 = new Smartphone(211, "IPhone11", 46999, "Apple");
    Product smartphone2 = new Smartphone(222, "Oppo Reno 5 Lite", 19999, "BBK Electronics");

    @Test
    public void shouldFindAll() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);

        int idToRemove = 111;
        repo. removeById(idToRemove);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }
}
