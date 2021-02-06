package product_shop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_shop.domain.dtos.CategorySeedDto;
import product_shop.domain.dtos.export.CategoryViewDto;
import product_shop.domain.entities.Category;
import product_shop.domain.entities.Product;
import product_shop.reositries.CategoryRepository;
import product_shop.reositries.ProductRepository;
import product_shop.services.interfaces.CategoryService;
import product_shop.utils.interfaces.ValidatorUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ValidatorUtil validatorUtil;
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidatorUtil validatorUtil, ModelMapper modelMapper, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public String seedCategories(List<CategorySeedDto> categorySeedDtoList) {
        if (this.categoryRepository.count() > 0) {
            return "Category data already filled!";
        }

        StringBuilder sb = new StringBuilder();
        categorySeedDtoList
                .stream()
                .map(categoryDto -> this.modelMapper.map(categoryDto, Category.class))
                .forEach(category -> {
                    if (this.validatorUtil.isValid(category)) {
                        sb.append(String.format("User %s successfully added.",
                                category.getName()));
                        sb.append(System.lineSeparator());

                        this.categoryRepository.saveAndFlush(category);

                    } else {
                        StringBuilder violationsString = new StringBuilder();
                        this.validatorUtil
                                .violations(category)
                                .forEach(violation -> violationsString.append(violation.getMessage()));
                        sb.append(violationsString.toString());
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }

    @Override
    public List<CategoryViewDto> getCategoriesByProductCount() {
        return this.categoryRepository
                .findAll()
                .stream()
                .map(category -> {
                    CategoryViewDto categoryViewDto = this.modelMapper.map(category, CategoryViewDto.class);

                    List<Product> products = this.productRepository
                            .findAllByCategory(category)
                            .orElseThrow(() -> new IllegalStateException(String
                                    .format("No products have been found with the given category %s",
                                            category.getName())));

                    BigDecimal totalRevenue = products
                            .stream()
                            .map(Product::getPrice)
                            .reduce(new BigDecimal("0"), BigDecimal::add);

                    BigDecimal averagePrice = totalRevenue.divide(new BigDecimal(products.size()) , RoundingMode.HALF_UP);

                    categoryViewDto.setProductCount(products.size());
                    categoryViewDto.setTotalRevenue(totalRevenue);
                    categoryViewDto.setAveragePrice(averagePrice);
                    return categoryViewDto;
                })
                .collect(Collectors.toList());
    }
}