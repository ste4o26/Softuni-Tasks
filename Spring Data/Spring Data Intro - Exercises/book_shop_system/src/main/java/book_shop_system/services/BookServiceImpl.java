package book_shop_system.services;

import book_shop_system.domain.entities.*;
import book_shop_system.repositories.AuthorRepository;
import book_shop_system.repositories.BookRepository;
import book_shop_system.repositories.CategoryRepository;
import book_shop_system.services.interfaces.BookService;
import book_shop_system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final FileUtil fileUtil;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookServiceImpl(FileUtil fileUtil,
                           BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<String> fetchBookTitlesAfter(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date is required and can not be null!");
        }

        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(date);
        List<String> titles = books
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());

        if (titles.isEmpty()) {
            throw new IllegalStateException(String.format("No books have been created after %d", date.getYear()));
        }

        return titles;
    }

    @Override
    public Set<String> fetchAuthorsWithBooksReleasedAfter(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date is required and can not be null!");
        }

        List<Book> books = this.bookRepository.findAllByReleaseDateBefore(date);
        Set<String> authors = books
                .stream()
                .map(book -> book.getAuthor().getFirstName()
                        .concat(" ")
                        .concat(book.getAuthor().getLastName()))
                .collect(Collectors.toSet());

        if (authors.isEmpty()) {
            throw new IllegalStateException(String.format("No authors with books released before %d", date.getYear()));
        }

        return authors;
    }

    @Override
    public List<String> fetchAllBooksWrittenByGeorgePowell() {
        Author author = this.authorRepository
                .findByFirstNameAndLastName("George", "Powell");

        if (author == null) {
            throw new IllegalArgumentException("Author with name George Powell does not exists!");
        }

        return this.bookRepository
                .findAllByAuthorOrderByReleaseDateDesc(author)
                .stream()
                .map(book -> String.format("%s %s %d.",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public void seedBooks() throws IOException, URISyntaxException {
        if (this.bookRepository.count() != 0) {
            return;
        }

        Path path = Paths.get(getClass()
                .getClassLoader()
                .getResource("files\\books.txt")
                .toURI());

        List<String> fileContent = this.fileUtil.getFileContent(path);
        fileContent
                .stream()
                .map(line -> line.split("\\s+"))
                .forEach(arr -> {
                    Book book = new Book();
                    book.setAuthor(this.getRandomAuthor());

                    //Getting the enum string value for the given enum index
                    EditionType editionType = EditionType.values()[Integer.parseInt(arr[0])];
                    book.setEditionType(editionType);

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
                    LocalDate releaseDate = LocalDate.parse(arr[1], dtf);
                    book.setReleaseDate(releaseDate);

                    int copies = Integer.parseInt(arr[2]);
                    book.setCopies(copies);

                    BigDecimal price = new BigDecimal(arr[3]);
                    book.setPrice(price);

                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(arr[4])];
                    book.setAgeRestriction(ageRestriction);

                    book.setTitle(arr[5]);

                    Set<Category> categories = new HashSet<>();
                    categories.add(this.getRandomCategory());
                    categories.add(this.getRandomCategory());
                    book.setCategories(categories);

                    this.bookRepository.save(book);
                });
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        long authorsCount = this.authorRepository.count();
        long authorIndex = random.nextInt((int) authorsCount - 1) + 1;

        //or findOne method
        Author author = this.authorRepository.findById(authorIndex)
                .orElse(null);

        return author;
    }

    private Category getRandomCategory() {
        Random random = new Random();
        long categoriesCount = this.categoryRepository.count();
        long authorIndex = random.nextInt((int) categoriesCount - 1) + 1;

        Category category = this.categoryRepository.findById(authorIndex)
                .orElse(null);

        return category;
    }
}