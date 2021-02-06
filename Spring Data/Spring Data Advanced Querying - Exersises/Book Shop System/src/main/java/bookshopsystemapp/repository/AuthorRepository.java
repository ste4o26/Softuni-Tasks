package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT a FROM authors AS a " +
            "WHERE  LOWER(a.firstName) LIKE %:suffix")
    List<Author> fetchAllEndsWith(@Param(value = "suffix") String suffix);

    @Query(value = "SELECT a FROM authors AS a")
    List<Author> fetchAll();

}
