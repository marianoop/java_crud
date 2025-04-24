package com.marianoop.java_crud.repositories;

import static com.marianoop.java_crud.utils.TestDataUtil.anyTestAuthor;
import static com.marianoop.java_crud.utils.TestDataUtil.anyTestBookA;
import static com.marianoop.java_crud.utils.TestDataUtil.anyTestBookB;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marianoop.java_crud.domain.Author;
import com.marianoop.java_crud.domain.Book;
import com.marianoop.java_crud.utils.TestDataUtil;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookRepositoryIntegrationTest {

    private final BookRepository sut;

    @Autowired
    public BookRepositoryIntegrationTest(BookRepository sut) {
        this.sut = sut;
    }

    @Test
    public void findById_Ok() {
        Author author = anyTestAuthor();

        Book book = sut.save(anyTestBookA(author));

        Optional<Book> result = sut.findById(book.getIsbn());

        assertTrue(result.isPresent());
        assertEquals(result.get(), book);
    }

    @Test
    public void findAll_Ok() {
        Author author = anyTestAuthor();

        Book bookA = sut.save(anyTestBookA(author));
        Book bookB = sut.save(anyTestBookB(author));

        Iterable<Book> result = sut.findAll();

        assertThat(result)
                .hasSize(2)
                .containsExactly(bookA, bookB);
    }

    @Test
    public void update_Ok() {
        Author author = TestDataUtil.anyTestAuthor();

        Book book = sut.save(anyTestBookA(author));

        book.setTitle("Updated Title");

        sut.save(book);

        Optional<Book> result = sut.findById(book.getIsbn());

        assertTrue(result.isPresent());
        assertEquals(result.get(), book);
    }

    @Test
    public void deleteOk() {
        Author author = anyTestAuthor();

        Book book = sut.save(anyTestBookA(author));

        sut.deleteById(book.getIsbn());

        Optional<Book> result = sut.findById(book.getIsbn());

        assertTrue(result.isEmpty());
    }
}
