package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    List<String> fetchAllBooksEndsWith(String suffix);

    List<String> fetchAllAuthorsAndTheirTotalCopies();
}
