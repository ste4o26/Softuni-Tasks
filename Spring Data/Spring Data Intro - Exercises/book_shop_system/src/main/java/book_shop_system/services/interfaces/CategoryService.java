package book_shop_system.services.interfaces;

import java.io.IOException;
import java.net.URISyntaxException;

public interface CategoryService {
    void seedCategories() throws IOException, URISyntaxException;
}
