package bookshopsystemapp.controller;

import bookshopsystemapp.service.AuthorService;
import bookshopsystemapp.service.BookService;
import bookshopsystemapp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

@Controller
public class BookshopController implements CommandLineRunner {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookshopController(AuthorService authorService,
                              CategoryService categoryService,
                              BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        this.seedDatabase();
//        this.booksTitlesByAgeRestriction();
//        this.goldenBooks();
//        this.booksByPrice();
//        this.notReleasedBooks();
//        this.booksReleasedBeforeDate();
//        this.booksSearch();
//        this.authorsSearch();
//        this.bookTitlesSearch();
//        this.countBooks();
        this.totalBookCopies();
    }

    private void seedDatabase() throws IOException {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();
    }

    /**
     * 1st Task
     */
    private void booksTitlesByAgeRestriction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter age restriction: ");
        String ageRestriction = reader.readLine().toUpperCase();

        this.bookService
                .fetchAllBooksByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    /**
     * 2nd Task
     */
    private void goldenBooks() {
        //Can be done with a reader which read the edition type from the console!
        String editionTypeAsString = "GOLD";

        this.bookService
                .fetchAllBooksByEditionType(editionTypeAsString)
                .forEach(System.out::println);
    }

    /**
     * 3rd Task
     */
    private void booksByPrice() {
        //Can be done with a reader which read both of the prices from the console!
        BigDecimal priceLowerThan = new BigDecimal("5");
        BigDecimal priceHigherThan = new BigDecimal("40");

        this.bookService
                .fetchAllBooksWithPriceLowerThanOrPriceHigherThan(priceLowerThan, priceHigherThan)
                .forEach(System.out::println);
    }

    /**
     * 4th Task
     */
    private void notReleasedBooks() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter an year: ");
        String yearAsString = reader.readLine();

        this.bookService
                .fetchAllBooksNotReleasedIn(yearAsString)
                .forEach(System.out::println);
    }

    /**
     * 5th Task
     */
    private void booksReleasedBeforeDate() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //USE DD-MM-YYYY(12-04-1992) FORMAT!
        System.out.print("Enter date: ");
        String dateAsString = reader.readLine();

        this.bookService
                .fetchAllBooksReleasedBefore(dateAsString)
                .forEach(System.out::println);
    }

    /**
     * 6th Task
     */
    private void authorsSearch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter suffix: ");
        String suffix = reader.readLine().toLowerCase();

        this.authorService
                .fetchAllBooksEndsWith(suffix)
                .forEach(System.out::println);
    }

    /**
     * 7th Task
     */
    private void booksSearch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter search string: ");
        String searchString = reader.readLine().toLowerCase();

        this.bookService
                .fetchAllBooksWhichContains(searchString)
                .forEach(System.out::println);
    }

    /**
     * 8th Task
     */
    private void bookTitlesSearch() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter prefix: ");
        String authorNamePrefix = reader.readLine().toLowerCase();

        this.bookService
                .fetchAllBooksByAuthorNameStartingWith(authorNamePrefix)
                .forEach(System.out::println);
    }

    /**
     * 9th Task
     */
    private void countBooks() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter title length: ");
        Integer titleLength = Integer.parseInt(reader.readLine());

        Integer booksCount = this.bookService
                .fetchCountOfBooksWithTitleLongerThan(titleLength);

        System.out.printf("There are %d books with longer title than %d symbols.%n",
                booksCount,
                titleLength);
    }

    /**
     * 10th Task
     */
    private void totalBookCopies() {
        this.authorService
                .fetchAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);
    }
}
