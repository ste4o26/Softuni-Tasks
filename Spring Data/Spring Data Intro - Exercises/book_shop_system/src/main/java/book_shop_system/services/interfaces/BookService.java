package book_shop_system.services.interfaces;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface BookService {
    void seedBooks() throws IOException, URISyntaxException;

    List<String> fetchBookTitlesAfter(LocalDate date);

    Set<String> fetchAuthorsWithBooksReleasedAfter(LocalDate date);

    List<String> fetchAllBooksWrittenByGeorgePowell();
}
