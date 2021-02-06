package product_shop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_shop.domain.dtos.ProductSeedDto;
import product_shop.domain.dtos.ProductViewDto;
import product_shop.domain.entities.Category;
import product_shop.domain.entities.Product;
import product_shop.domain.entities.User;
import product_shop.reositries.CategoryRepository;
import product_shop.reositries.ProductRepository;
import product_shop.reositries.UserRepository;
import product_shop.services.interfaces.ProductService;
import product_shop.utils.interfaces.ValidatorUtil;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public String seedProducts(List<ProductSeedDto> productSeedDtoList) {
        if (this.productRepository.count() > 0) {
            return "Product data already filled!";
        }

        StringBuilder sb = new StringBuilder();
        productSeedDtoList
                .stream()
                .map(productDto -> this.modelMapper.map(productDto, Product.class))
                .map(product -> {
                    product.setBuyer(this.getRandomUser());
                    product.setSeller(this.getRandomUser());
                    return product;
                })
                .forEach(product -> {
                    if (this.validatorUtil.isValid(product)) {
                        sb.append(String.format("Product %s successfully added.",
                                product.getName()));
                        sb.append(System.lineSeparator());

                        this.productRepository.saveAndFlush(product);

                    } else {
                        StringBuilder violationsString = new StringBuilder();
                        this.validatorUtil
                                .violations(product)
                                .forEach(violation -> violationsString.append(violation.getMessage()));
                        sb.append(violationsString.toString());
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }

    @Override
    public void addRandomCategoriesToAllProducts() {
        this.productRepository
                .findAll()
                .stream()
                .map(product -> {
                    Set<Category> categories = this.getTwoRandomCategories();
                    product.setCategories(categories);
                    return product;
                })
                .forEach(this.productRepository::saveAndFlush);
    }

    @Override
    public List<ProductViewDto> getProductsInRange(BigDecimal from, BigDecimal to) throws IllegalStateException {
        return this.productRepository
                .findAllByPriceIsBetweenAndBuyerIsNull(from, to)
                .orElseThrow(() -> new IllegalStateException("No products without a buyer has been found!"))
                .stream()
                .map(product -> this.modelMapper.map(product, ProductViewDto.class))
                .collect(Collectors.toList());
    }

    private Set<Category> getTwoRandomCategories() {
        Set<Category> categories = new HashSet<>();

        for (int i = 0; i < 2; i++) {
            Long categoryId = this.getRandomIndex((int) this.categoryRepository.count());
            Category category = this.categoryRepository
                    .findById(categoryId)
                    .orElseThrow(() -> new IllegalStateException(String
                            .format("Category with id %d does not exists!", categoryId)));

            categories.add(category);
        }

        return categories;
    }

    private User getRandomUser() {
        Long userId = this.getRandomIndex((int) this.userRepository.count());
        return this.userRepository
                .findById(userId)
                .orElseThrow(() -> new IllegalStateException(String.format("Buyer with id %d does not exists!", userId)));
    }

    private Long getRandomIndex(Integer bounds) {
        Random random = new Random();
        return (long) random.nextInt(bounds) + 1;
    }
}
