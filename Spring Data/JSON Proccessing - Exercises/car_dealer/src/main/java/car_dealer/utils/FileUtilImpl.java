package car_dealer.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileUtilImpl implements FileUtil {
    private Path path;

    public FileUtilImpl() {
    }

    @Override
    public List<String> getFileLines(String relativePath) throws IOException, URISyntaxException {
        this.path = Paths.get(getClass()
                .getClassLoader()
                .getResource(relativePath)
                .toURI());

        return Files
                .readAllLines(this.path)
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
