package book_shop_system.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileUtilImpl implements FileUtil {

    @Override
    public List<String> getFileContent(Path path) throws IOException {
        List<String> fileContent = Files.readAllLines(path);
        return fileContent
                .stream()
                .filter(line -> !line.equals(""))
                .collect(Collectors.toList());
    }
}
