package book_shop_system.repositories;

import book_shop_system.domain.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByFirstNameAndLastName(String firstName, String lastName);
}
