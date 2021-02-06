package bookshopsystemapp.repository;

import bookshopsystemapp.domain.entities.AgeRestriction;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.domain.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    @Query(value = "SELECT b FROM books AS b " +
            "WHERE b.ageRestriction = :ageRestriction")
    List<Book> fetchAllByAgeRestriction(@Param(value = "ageRestriction") AgeRestriction ageRestriction);

    @Query(value = "SELECT b FROM books AS b " +
            "WHERE b.editionType = :editionType " +
            "AND b.copies < 5000")
    List<Book> fetchAllByEditionType(@Param(value = "editionType") EditionType editionType);

    @Query(value = "SELECT b FROM books AS b " +
            "WHERE b.price < :priceLowerThan " +
            "OR b.price > :priceHigherThan")
    List<Book> fetchAllWithPriceLowerThanOrPriceHigherThan(@Param(value = "priceLowerThan") BigDecimal priceLowerThan,
                                                           @Param(value = "priceHigherThan") BigDecimal priceHigherThan);


    //Can not use quite of functions in JPQL so have to think for a make around solutions!
    @Query(value = "SELECT b FROM books AS b " +
            "WHERE b.releaseDate < :before " +
            "OR b.releaseDate > :after")
    List<Book> fetchAllNotReleasedBetween(@Param(value = "before") LocalDate before,
                                          @Param(value = "after") LocalDate after);

    @Query(value = "SELECT b FROM books AS b " +
            "WHERE LOWER(b.title) LIKE %:searchString%")
    List<Book> fetchAllWhereTitleLike(@Param(value = "searchString") String searchString);

    @Query(value = "SELECT b FROM books AS b " +
            "WHERE LOWER(b.author.lastName) LIKE :authorNamePrefix%")
    List<Book> fetchAllByAuthorNameStartingWith(@Param(value = "authorNamePrefix") String authorNamePrefix);

    @Query(value = "SELECT COUNT(b.id) FROM books AS b " +
            "WHERE LENGTH(b.title) > :titleLength")
    Integer fetchCountWithTitleLongerThan(@Param(value = "titleLength") Integer titleLength);


}
