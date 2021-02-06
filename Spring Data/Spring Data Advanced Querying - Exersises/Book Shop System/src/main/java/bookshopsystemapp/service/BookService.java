package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBooksTitlesAfter();

    Set<String> getAllAuthorsWithBookBefore();

    List<String> fetchAllBooksByAgeRestriction(String ageRestrictionAsString);

    List<String> fetchAllBooksByEditionType(String editionTypeAsString);

    List<String> fetchAllBooksWithPriceLowerThanOrPriceHigherThan(BigDecimal priceLowerThan, BigDecimal priceHigherThan);

    List<String> fetchAllBooksNotReleasedIn(String yearAsString);

    List<String> fetchAllBooksReleasedBefore(String dateAsString);

    List<String> fetchAllBooksWhichContains(String searchString);

    List<String> fetchAllBooksByAuthorNameStartingWith(String authorNameSuffix);

    Integer fetchCountOfBooksWithTitleLongerThan(Integer titleLength);
}
