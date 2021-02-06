package book_shop_system.services;

import book_shop_system.domain.entities.Author;
import book_shop_system.repositories.AuthorRepository;
import book_shop_system.services.interfaces.AuthorService;
import book_shop_system.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public List<String> fetchAllAuthorsAndTheirBooksCount() {
        List<Author> authors = this.authorRepository.findAll();
        List<String> authorsBooks = authors
                .stream()
                .sorted((f, s) -> s.getBooks().size() - f.getBooks().size())
                .map(author -> String.format("%s %s wrote %d books.",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());

        if (authorsBooks.isEmpty()) {
            throw new IllegalStateException("No authors have been found!");
        }

        return authorsBooks;
    }

    @Override
    public void seedAuthors() throws IOException, URISyntaxException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        Path path = Paths.get(getClass()
                .getClassLoader()
                .getResource("files\\authors.txt")
                .toURI());

        List<String> fileContent = this.fileUtil.getFileContent(path);
        List<Author> authors = fileContent
                .stream()
                .map(line -> line.split("\\s+"))
                .map(arr -> new Author(arr[0], arr[1]))
                .collect(Collectors.toList());

        for (Author author : authors) {
            this.authorRepository.save(author);
        }
    }
}
