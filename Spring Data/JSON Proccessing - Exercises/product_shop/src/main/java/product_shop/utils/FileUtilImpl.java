package product_shop.utils;

import org.springframework.stereotype.Component;
import product_shop.utils.interfaces.FileUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class FileUtilImpl implements FileUtil {
    private Path path;

    public FileUtilImpl() {
    }

    @Override
    public List<String> getFileLines(String relativePath) throws URISyntaxException, IOException {
        this.path = Paths.get(getClass()
                .getClassLoader()
                .getResource(relativePath)
                .toURI());

        return Files
                .readAllLines(this.path);
    }
}
