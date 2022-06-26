package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();

    Book book1 = new Book(111, "Gone With the Wind", 555, "Margaret Mitchel");
    Book book2 = new Book(122, "Jane Eyre", 444, "Charlotte Bronte");
    Smartphone smartphone1 = new Smartphone(211, "IPhone11", 46999, "Apple");
    Smartphone smartphone2 = new Smartphone(222, "Oppo Reno 5 Lite", 19999, "BBK Electronics");

    @Test
    void shouldSearchWord() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("it");
        Product[] expected = {book1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameBook() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Jane Eyre");
        Product[] expected = {book2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNameSmartphone() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}