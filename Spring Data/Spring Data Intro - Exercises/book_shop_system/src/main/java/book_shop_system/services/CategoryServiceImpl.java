package book_shop_system.services;

import book_shop_system.domain.entities.Category;
import book_shop_system.repositories.CategoryRepository;
import book_shop_system.services.interfaces.CategoryService;
import book_shop_system.util.FileUtil;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final FileUtil fileUtil;
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(FileUtil fileUtil, CategoryRepository categoryRepository) {
        this.fileUtil = fileUtil;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void seedCategories() throws IOException, URISyntaxException {
        if(this.categoryRepository.count() != 0){
            return;
        }

        Path path = Paths.get(getClass()
                .getClassLoader()
                .getResource("files\\categories.txt")
                .toURI());

        List<String> fileContent = this.fileUtil.getFileContent(path);
        List<Category> categories = fileContent
                .stream()
                .map(line -> line.split("\\s+"))
                .map(arr -> new Category(arr[0]))
                .collect(Collectors.toList());

        categories.forEach(this.categoryRepository::save);
    }
}
