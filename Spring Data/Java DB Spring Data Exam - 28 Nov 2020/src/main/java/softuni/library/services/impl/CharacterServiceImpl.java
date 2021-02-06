package softuni.library.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.library.models.dtos.CharacterCreateDtoList;
import softuni.library.models.entities.Book;
import softuni.library.models.entities.Character;
import softuni.library.repositories.BookRepository;
import softuni.library.repositories.CharacterRepository;
import softuni.library.services.CharacterService;
import softuni.library.util.ValidatorUtil;
import softuni.library.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {
    private static final String CHARACTERS_XML_PATH = "src/main/resources/files/xml/characters.xml";

    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private BookRepository bookRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidatorUtil validatorUtil, BookRepository bookRepository) {
        this.characterRepository = characterRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.bookRepository = bookRepository;
    }

    @Override
    public boolean areImported() {
        return this.characterRepository.count() > 0;
    }

    @Override
    public String readCharactersFileContent() throws IOException {
        return String.join("", Files.readAllLines(Path.of(CHARACTERS_XML_PATH)));
    }

    @Override
    public String importCharacters() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        this.xmlParser
                .fromXml(CHARACTERS_XML_PATH, CharacterCreateDtoList.class)
                .getCharacters()
                .forEach(characterDto -> {
                    Optional<Book> bookById = this.bookRepository.findById(characterDto.getBook().getId());
                    if (!this.validatorUtil.isValid(characterDto) || bookById.isEmpty()) {
                        sb.append("Invalid Character")
                                .append(System.lineSeparator());
                        return;
                    }

                    Character character = this.modelMapper.map(characterDto, Character.class);
                    character.setBook(bookById.get());

                    sb.append(String
                            .format("Successfully imported Character: %s %s %s - age: %s",
                                    character.getFirstName(),
                                    character.getMiddleName(),
                                    character.getLastName(),
                                    character.getAge()))
                            .append(System.lineSeparator());

                    this.characterRepository.saveAndFlush(character);
                });

        return sb.toString();
    }

    @Override
    public String findCharactersInBookOrderedByLastNameDescendingThenByAge() {
        StringBuilder sb = new StringBuilder();
        Optional<List<Character>> characters = this.characterRepository.exportCharacters();
        try {
            characters
                    .get()
                    .forEach(character -> sb.append(String
                            .format("Character name %s %s %s, %d, in book %s",
                                    character.getFirstName(),
                                    character.getMiddleName(),
                                    character.getLastName(),
                                    character.getAge(),
                                    character.getBook().getName()))
                            .append(System.lineSeparator()));
        } catch (NoSuchElementException nse) {
            sb.append("Something went wrong!")
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }
}
