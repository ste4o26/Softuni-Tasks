package bookshopsystemapp.service;

import bookshopsystemapp.domain.entities.Author;
import bookshopsystemapp.domain.entities.Book;
import bookshopsystemapp.repository.AuthorRepository;
import bookshopsystemapp.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final static String AUTHORS_FILE_PATH =
            "D:\\IntelliJ Projects\\softUni\\Spring Data\\Spring Data Advanced Querying - Exersises\\Book Shop System\\src\\main\\resources\\files\\authors.txt";

    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }

        String[] authorFileContent = this.fileUtil.getFileContent(AUTHORS_FILE_PATH);
        for (String line : authorFileContent) {
            String[] names = line.split("\\s+");

            Author author = new Author();
            author.setFirstName(names[0]);
            author.setLastName(names[1]);

            this.authorRepository.saveAndFlush(author);
        }
    }

    /**
     * Homework tasks starts from here!
     */

    @Override
    public List<String> fetchAllBooksEndsWith(String suffix) {
        if (suffix == null || suffix.trim().isEmpty()) {
            throw new IllegalArgumentException("Suffix can not be null or empty!");
        }

        return this.authorRepository
                .fetchAllEndsWith(suffix)
                .stream()
                .map(author -> String.format("%s %s", author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> fetchAllAuthorsAndTheirTotalCopies() {
        return this.authorRepository
                .fetchAll()
                .stream()
                .map(author -> {
                    Integer currentAuthorTotalCopies = 0;
                    for (Book book : author.getBooks()) {
                        currentAuthorTotalCopies += book.getCopies();
                    }

                    return String.format("%s %s - %d",
                            author.getFirstName(),
                            author.getLastName(),
                            currentAuthorTotalCopies);
                })
                .collect(Collectors.toList());
    }


}
