package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.*;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.repository.BookRepository;
import bookshopsystemapp.repository.CategoryRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH =
            "D:\\IntelliJ Projects\\softUni\\Spring Data\\Spring Data Advanced Querying - Exersises\\Book Shop System\\src\\main\\resources\\files\\books.txt";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, CategoryRepository categoryRepository, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
        this.fileUtil = fileUtil;
    }

    private Author getRandomAuthor() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.authorRepository.count() - 1)) + 1;

        return this.authorRepository.findById(randomId).orElse(null);
    }

    private Set<Category> getRandomCategories() {
        Set<Category> categories = new LinkedHashSet<>();

        Random random = new Random();
        int length = random.nextInt(5);

        for (int i = 0; i < length; i++) {
            Category category = this.getRandomCategory();

            categories.add(category);
        }

        return categories;
    }

    private Category getRandomCategory() {
        Random random = new Random();

        int randomId = random.nextInt((int) (this.categoryRepository.count() - 1)) + 1;

        return this.categoryRepository.findById(randomId).orElse(null);
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        String[] booksFileContent = this.fileUtil.getFileContent(BOOKS_FILE_PATH);
        for (String line : booksFileContent) {
            String[] lineParams = line.split("\\s+");

            Book book = new Book();
            book.setAuthor(this.getRandomAuthor());

            EditionType editionType = EditionType.values()[Integer.parseInt(lineParams[0])];
            book.setEditionType(editionType);

            LocalDate releaseDate = LocalDate.parse(lineParams[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
            book.setReleaseDate(releaseDate);

            int copies = Integer.parseInt(lineParams[2]);
            book.setCopies(copies);

            BigDecimal price = new BigDecimal(lineParams[3]);
            book.setPrice(price);

            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(lineParams[4])];
            book.setAgeRestriction(ageRestriction);

            StringBuilder title = new StringBuilder();
            for (int i = 5; i < lineParams.length; i++) {
                title.append(lineParams[i]).append(" ");
            }

            book.setTitle(title.toString().trim());

            Set<Category> categories = this.getRandomCategories();
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);
        }
    }

    @Override
    public List<String> getAllBooksTitlesAfter() {
        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(LocalDate.parse("2000-12-31"));

        return books.stream().map(b -> b.getTitle()).collect(Collectors.toList());
    }

    @Override
    public Set<String> getAllAuthorsWithBookBefore() {
        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(LocalDate.parse("1990-01-01"));

        return books.stream().map(b -> String.format("%s %s", b.getAuthor().getFirstName(), b.getAuthor().getLastName())).collect(Collectors.toSet());
    }

    /**
     * Homework tasks starts from here!
     */

    @Override
    public List<String> fetchAllBooksByAgeRestriction(String ageRestrictionAsString) {
        if (ageRestrictionAsString == null || ageRestrictionAsString.trim().equals("")) {
            throw new IllegalArgumentException("Age restriction can not be null or empty string!");
        }

        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionAsString);
        List<Book> books = this.bookRepository
                .fetchAllByAgeRestriction(ageRestriction);

        return this.mapBooksToTitles(books);


    }

    @Override
    public List<String> fetchAllBooksByEditionType(String editionTypeAsString) {
        if (editionTypeAsString == null || editionTypeAsString.trim().isEmpty()) {
            throw new IllegalArgumentException("Edition type can not be null or empty!");
        }

        EditionType editionType = EditionType.valueOf(editionTypeAsString);
        List<Book> books = this.bookRepository
                .fetchAllByEditionType(editionType);

        return this.mapBooksToTitles(books);
    }

    @Override
    public List<String> fetchAllBooksWithPriceLowerThanOrPriceHigherThan(BigDecimal priceLowerThan, BigDecimal priceHigherThan) {
        if (priceLowerThan == null || priceHigherThan == null) {
            throw new IllegalArgumentException("Both prices can not be null!");
        }

        return this.bookRepository
                .fetchAllWithPriceLowerThanOrPriceHigherThan(priceLowerThan, priceHigherThan)
                .stream()
                .map(book -> String.format("%s $%.2f", book.getTitle(), book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> fetchAllBooksNotReleasedIn(String yearAsString) {
        if (yearAsString == null || yearAsString.trim().isEmpty()) {
            throw new IllegalArgumentException("Year can not be null or empty!");
        }

        LocalDate before = LocalDate.parse(String.format("%s-01-01", yearAsString));
        LocalDate after = LocalDate.parse(String.format("%s-12-31", yearAsString));

        List<Book> books = this.bookRepository
                .fetchAllNotReleasedBetween(before, after);

        return this.mapBooksToTitles(books);
    }

    @Override
    public List<String> fetchAllBooksReleasedBefore(String dateAsString) {
        if (dateAsString == null || dateAsString.trim().isEmpty()) {
            throw new IllegalArgumentException("Date can not be null or empty!");
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateAsString, dtf);

        return this.bookRepository
                .findAllByReleaseDateBefore(date)
                .stream()
                .map(book -> String.format("%s %s $%.2f",
                        book.getTitle(),
                        book.getEditionType().name(),
                        book.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> fetchAllBooksWhichContains(String searchString) {
        if (searchString == null || searchString.trim().isEmpty()) {
            throw new IllegalArgumentException("Search input can not be null or empty!");
        }

        List<Book> books = this.bookRepository
                .fetchAllWhereTitleLike(searchString);

        return this.mapBooksToTitles(books);
    }

    @Override
    public List<String> fetchAllBooksByAuthorNameStartingWith(String authorNameSuffix) {
        if (authorNameSuffix == null || authorNameSuffix.trim().isEmpty()) {
            throw new IllegalArgumentException("Search input can not be null or empty!");
        }

        return this.bookRepository
                .fetchAllByAuthorNameStartingWith(authorNameSuffix)
                .stream()
                .map(book -> String.format("%s (%s %s)", book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public Integer fetchCountOfBooksWithTitleLongerThan(Integer titleLength) {
        if (titleLength == null || titleLength < 0) {
            throw new IllegalArgumentException("Title length can not be null or negative number!");
        }

        return this.bookRepository
                .fetchCountWithTitleLongerThan(titleLength);
    }

    private List<String> mapBooksToTitles(List<Book> books) {
        return books
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

}
