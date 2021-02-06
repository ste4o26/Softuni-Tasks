package softuni.library.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.library.models.dtos.BookCreateDto;
import softuni.library.models.entities.Author;
import softuni.library.models.entities.Book;
import softuni.library.repositories.AuthorRepository;
import softuni.library.repositories.BookRepository;
import softuni.library.services.BookService;
import softuni.library.util.ValidatorUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static final String BOOK_JSON_PATH = "src/main/resources/files/json/books.json";
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;
    private AuthorRepository authorRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
        this.authorRepository = authorRepository;
    }


    @Override
    public boolean areImported() {
        return this.bookRepository.count() > 0;
    }

    @Override
    public String readBooksFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(BOOK_JSON_PATH)));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson
                .fromJson(this.readBooksFileContent(), BookCreateDto[].class))
                .forEach(bookDto -> {
                    if (!this.validatorUtil.isValid(bookDto)){
                        sb.append("Invalid Book")
                                .append(System.lineSeparator());
                        return;
                    }

                    Optional<Author> authorById = this.authorRepository.findById(bookDto.getAuthor());
                    if (authorById.isEmpty()){
                        sb.append("Invalid Book")
                                .append(System.lineSeparator());
                        return;
                    }

                    Book book = this.modelMapper.map(bookDto, Book.class);
                    book.setAuthor(authorById.get());

                    sb.append(String
                            .format("Successfully imported Book: %s written in %s",
                                    book.getName(),
                                    book.getWritten().toString()))
                            .append(System.lineSeparator());

                    //todo
                    this.bookRepository.saveAndFlush(book);
                });

        return sb.toString();
    }
}
