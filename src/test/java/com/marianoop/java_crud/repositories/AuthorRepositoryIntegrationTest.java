package com.marianoop.java_crud.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.marianoop.java_crud.domain.entities.Author;
import com.marianoop.java_crud.utils.TestDataUtil;
import java.util.List;
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
public class AuthorRepositoryIntegrationTest {

    private final AuthorRepository sut;

    @Autowired
    public AuthorRepositoryIntegrationTest(AuthorRepository sut) {
        this.sut = sut;
    }

    @Test
    public void findById_Ok() {
        Author author = TestDataUtil.anyTestAuthor();

        sut.save(author);

        Optional<Author> result = sut.findById(author.getId());

        assertTrue(result.isPresent());
        assertEquals(result.get(), author);
    }

    @Test
    public void findAll_Ok() {
        Author authorA = TestDataUtil.anyTestAuthor();
        Author authorB = TestDataUtil.anyTestAuthor();

        sut.save(authorA);
        sut.save(authorB);

        Iterable<Author> result = sut.findAll();

        assertThat(result)
                .hasSize(2)
                .containsExactly(authorA, authorB);
    }

    @Test
    public void update_Ok() {
        Author author = TestDataUtil.anyTestAuthor();

        sut.save(author);

        author.setName("Updated Name");

        sut.save(author);

        Optional<Author> result = sut.findById(author.getId());

        assertTrue(result.isPresent());
        assertEquals(result.get(), author);
    }

    @Test
    public void delete_Ok() {
        Author author = TestDataUtil.anyTestAuthor();

        sut.save(author);
        sut.deleteById(author.getId());

        Optional<Author> result = sut.findById(author.getId());

        assertTrue(result.isEmpty());
    }

    @Test
    public void findByAgeLessThan_Ok() {
        Author authorA = TestDataUtil.anyTestAuthor(20);
        Author authorB = TestDataUtil.anyTestAuthor(35);
        Author authorC = TestDataUtil.anyTestAuthor(45);

        sut.save(authorA);
        sut.save(authorB);
        sut.save(authorC);

        List<Author> result = sut.findByAgeLessThan(40);

        assertThat(result)
                .hasSize(2)
                .containsExactly(authorA, authorB);
    }
}
