package com.marianoop.java_crud.repositories;

import com.marianoop.java_crud.domain.entities.Author;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByAgeLessThan(int age);
}
