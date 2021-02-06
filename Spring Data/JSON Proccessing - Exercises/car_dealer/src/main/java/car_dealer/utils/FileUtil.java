package car_dealer.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface FileUtil {
    List<String> getFileLines(String relativePath) throws IOException, URISyntaxException;
}
