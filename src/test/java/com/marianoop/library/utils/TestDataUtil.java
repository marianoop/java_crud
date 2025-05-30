package com.marianoop.library.utils;


import com.marianoop.library.domain.entities.Author;
import com.marianoop.library.domain.entities.Book;

public class TestDataUtil {
    public static Author anyTestAuthor() {
        return anyTestAuthor(72);
    }

    public static Author anyTestAuthor(int age) {
        return Author.builder()
                .name("Jorge Luis")
                .age(age)
                .build();
    }

    public static Book anyTestBookA(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static Book anyTestBookB(Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }
}
