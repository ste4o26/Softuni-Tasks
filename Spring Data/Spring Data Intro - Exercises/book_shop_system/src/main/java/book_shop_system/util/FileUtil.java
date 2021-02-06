package book_shop_system.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileUtil {
    List<String> getFileContent(Path path) throws IOException;
}
