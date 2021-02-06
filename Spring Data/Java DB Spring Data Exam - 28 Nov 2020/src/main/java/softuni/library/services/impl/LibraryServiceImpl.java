package softuni.library.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.library.models.dtos.LibraryCreateDtoList;
import softuni.library.models.entities.Book;
import softuni.library.models.entities.Library;
import softuni.library.repositories.BookRepository;
import softuni.library.repositories.LibraryRepository;
import softuni.library.services.LibraryService;
import softuni.library.util.ValidatorUtil;
import softuni.library.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    private static final String LIBRARY_XML_PATH = "src/main/resources/files/xml/libraries.xml";

    private final LibraryRepository libraryRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private BookRepository bookRepository;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidatorUtil validatorUtil, BookRepository bookRepository) {
        this.libraryRepository = libraryRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean areImported() {
        return this.libraryRepository.count() > 0;
    }

    @Override
    public String readLibrariesFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(LIBRARY_XML_PATH)));
    }

    @Override
    public String importLibraries() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        this.xmlParser
                .fromXml(LIBRARY_XML_PATH, LibraryCreateDtoList.class)
                .getLibraries()
                .forEach(libraryDto -> {
                    Optional<Book> bookById = this.bookRepository.findById(libraryDto.getBook().getId());
                    if (!this.validatorUtil.isValid(libraryDto) || bookById.isEmpty()) {
                        sb.append("Invalid Library")
                                .append(System.lineSeparator());
                        return;
                    }

                    Library library;
                    try {
                        library = this.libraryRepository.findByName(libraryDto.getName()).get();

                    } catch (NoSuchElementException nse) {
                        library = this.modelMapper.map(libraryDto, Library.class);
                        library.setBooks(new HashSet<>());
                        sb.append(String.format("Successfully added Library: %s - %s",
                                library.getName(),
                                library.getLocation()))
                                .append(System.lineSeparator());
                    }

                    library.getBooks().add(bookById.get());
                    this.libraryRepository.saveAndFlush(library);


                });

        return sb.toString();
    }
}
