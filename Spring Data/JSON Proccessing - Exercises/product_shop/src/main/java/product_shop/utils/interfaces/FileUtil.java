package product_shop.utils.interfaces;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface FileUtil {
    List<String> getFileLines(String relativePath) throws URISyntaxException, IOException;

}
