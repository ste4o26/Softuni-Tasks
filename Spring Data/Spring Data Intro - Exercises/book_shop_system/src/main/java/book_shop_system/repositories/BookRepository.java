package book_shop_system.repositories;

import book_shop_system.domain.entities.Author;
import book_shop_system.domain.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByAuthorOrderByReleaseDateDesc(Author author);
}
