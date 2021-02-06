package book_shop_system.controlers;

import book_shop_system.services.interfaces.AuthorService;
import book_shop_system.services.interfaces.BookService;
import book_shop_system.services.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * 0.1 Task - create database using code first approach
 * 0.2 Task - create repositories and services
 * 0.3 Task - create a class which is responsible to read the data from the provided files
 * 0.4 Task - seed data into the database (use the data from the provided files. Read it via already created class)
 * 1-4 Tasks - create the queries
 */

@Controller
public class BookShopController implements CommandLineRunner {
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final BookService bookService;

    @Autowired
    public BookShopController(AuthorService authorService,
                              CategoryService categoryService,
                              BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            this.seedDatabase();
//            this.printBookTitlesAfter2000();
//            this.printAuthorsWithBooksReleasedBefore1990();
//            this.printAllAuthorsWithTheirBookCount();
//            this.printAllBooksWrittenByGeorgePowell();

        } catch (IllegalArgumentException | IllegalStateException | IOException | URISyntaxException e) {
            System.out.println(String.format("%s Exception with message: %s",
                    e.getClass().getSimpleName(),
                    e.getMessage()));
//            TODO in case of URISyntaxException please uncomment the following line bellow so you can easily track the exception!
//            e.printStackTrace();
        }

    }

    /**
     * Task 0.4 Seeding Database With Data
     */
    public void seedDatabase() throws IOException, URISyntaxException {
        this.authorService.seedAuthors();
        this.categoryService.seedCategories();
        this.bookService.seedBooks();
    }

    /**
     * -------
     * QUERIES
     * -------
     */

    /**
     * Task 1 Books Titles After 2000
     */
    public void printBookTitlesAfter2000() throws IOException{
        String dateAsString = "31-12-2000";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate date = LocalDate.parse(dateAsString, dtf);

        this.bookService.fetchBookTitlesAfter(date).forEach(System.out::println);
    }

    /**
     * Task 2 Authors with books released before 1990
     */
    public void printAuthorsWithBooksReleasedBefore1990() throws IOException{
        String dateAsString = "01-01-1990";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-yyyy");
        LocalDate date = LocalDate.parse(dateAsString, dtf);

        this.bookService.fetchAuthorsWithBooksReleasedAfter(date).forEach(System.out::println);
    }

    /**
     * Task 3 Authors with book count
     */
    public void printAllAuthorsWithTheirBookCount() throws IOException{
        this.authorService.fetchAllAuthorsAndTheirBooksCount().forEach(System.out::println);
    }

    /**
     * Task 4 All books written by George Powell
     */
    public void printAllBooksWrittenByGeorgePowell() throws IOException{
        this.bookService
                .fetchAllBooksWrittenByGeorgePowell()
                .forEach(System.out::println);
    }
}
