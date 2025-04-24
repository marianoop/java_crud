package com.marianoop.java_crud.utils;

import com.marianoop.java_crud.domain.Author;
import com.marianoop.java_crud.domain.Book;

public class TestDataUtil {
    public static Author anyTestAuthor() {
        return Author.builder()
                .name("Jorge Luis")
                .age(72)
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
