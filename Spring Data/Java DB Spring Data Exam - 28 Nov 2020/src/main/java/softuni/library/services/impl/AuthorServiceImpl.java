package softuni.library.services.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.library.models.dtos.AuthorCreateDto;
import softuni.library.models.entities.Author;
import softuni.library.repositories.AuthorRepository;
import softuni.library.services.AuthorService;
import softuni.library.util.ValidatorUtil;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AuthorServiceImpl implements AuthorService {
    private static final String AUTHOR_JSON_PATH = "src/main/resources/files/json/authors.json";
    private final AuthorRepository authorRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.authorRepository = authorRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.authorRepository.count() > 0;
    }

    @Override
    public String readAuthorsFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(AUTHOR_JSON_PATH)));
    }

    @Override
    public String importAuthors() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(this.gson
                .fromJson(this.readAuthorsFileContent(), AuthorCreateDto[].class))
                .forEach(authorDto -> {
                    if (!this.validatorUtil.isValid(authorDto)) {
                        sb.append("Invalid Author")
                                .append(System.lineSeparator());
                        return;
                    }

                    Author author = this.modelMapper.map(authorDto, Author.class);

                    sb.append(String
                            .format("Successfully imported Author: %s %s - %s",
                                    author.getFirstName(),
                                    author.getLastName(),
                                    author.getBirthTown()))
                            .append(System.lineSeparator());

                    this.authorRepository.saveAndFlush(author);
                });

        return sb.toString();
    }
}
