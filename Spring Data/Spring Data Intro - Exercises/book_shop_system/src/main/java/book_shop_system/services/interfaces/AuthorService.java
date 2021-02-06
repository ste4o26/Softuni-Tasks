package book_shop_system.services.interfaces;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException, URISyntaxException;

    List<String> fetchAllAuthorsAndTheirBooksCount();
}
