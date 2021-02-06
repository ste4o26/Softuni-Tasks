package product_shop.web.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import product_shop.domain.dtos.*;
import product_shop.domain.dtos.ProductViewDto;
import product_shop.domain.dtos.SellerDetailViewDto;
import product_shop.domain.dtos.export.CategoryViewDto;
import product_shop.domain.dtos.export.UserProductViewDto;
import product_shop.services.interfaces.CategoryService;
import product_shop.services.interfaces.ProductService;
import product_shop.services.interfaces.UserService;
import product_shop.utils.interfaces.FileUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductShopController implements CommandLineRunner {
    private final FileUtil fileUtil;
    private final UserService userService;
    private final Gson gson;
    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductShopController(FileUtil fileUtil, UserService userService, Gson gson, ProductService productService, CategoryService categoryService) {
        this.fileUtil = fileUtil;
        this.userService = userService;
        this.gson = gson;
        this.productService = productService;
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        try {
//            this.seedDatabase();
//            this.productsInRange();
//            this.successfullySoldProducts();
//            this.categoriesByProductsCount();
            this.usersAndProducts();
        } catch (IllegalStateException ise) {
            System.err.println(String
                    .format("%s with message: %s",
                            ise.getClass().getSimpleName(),
                            ise.getMessage()));
        }
    }

    public void seedDatabase() {
        try {
            this.seedUsers();
            this.seedProducts();
            this.seedCategories();
            this.addCategoriesToProducts();
        } catch (IOException | URISyntaxException e) {
            System.err.println(String.format("%s with message: %s",
                    e.getClass().getSimpleName(),
                    e.getMessage()));
        }
    }

    private void seedUsers() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/users.json"));

        List<UserSeedDto> userSeedDtoList = Arrays
                .stream(this.gson.fromJson(json, UserSeedDto[].class))
                .collect(Collectors.toList());

        String output = this.userService.seedUsers(userSeedDtoList);
        System.out.println(output);
    }

    private void seedProducts() throws IOException, URISyntaxException, IllegalStateException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/products.json"));

        List<ProductSeedDto> productSeedDtoList = Arrays
                .stream(this.gson.fromJson(json, ProductSeedDto[].class))
                .collect(Collectors.toList());

        String output = this.productService.seedProducts(productSeedDtoList);
        System.out.println(output);
    }

    private void seedCategories() throws IOException, URISyntaxException {
        String json = String.join("", this.fileUtil
                .getFileLines("files/categories.json"));

        List<CategorySeedDto> categorySeedDtoList = Arrays
                .stream(this.gson.fromJson(json, CategorySeedDto[].class))
                .collect(Collectors.toList());

        String output = this.categoryService.seedCategories(categorySeedDtoList);
        System.out.println(output);
    }

    private void addCategoriesToProducts() {
        this.productService.addRandomCategoriesToAllProducts();
    }

    /**
     * Query 1 – Products in Range
     */
    public void productsInRange() {
        BigDecimal from = new BigDecimal("500");
        BigDecimal to = new BigDecimal("1000");

        List<ProductViewDto> productViewDtoList = this.productService
                .getProductsInRange(from, to);

        String json = this.gson.toJson(productViewDtoList);
        System.out.println(json);
    }

    /**
     * Query 2 – Successfully Sold Products
     */
    public void successfullySoldProducts() {
        List<SellerDetailViewDto> sellerDetailViewDtoList = this.userService.getSellersWithSuccessfullySoldProducts();
        String json = this.gson.toJson(sellerDetailViewDtoList);
        System.out.println(json);
    }

    /**
     * Query 3 – Categories by Products Count
     */
    public void categoriesByProductsCount() {
        List<CategoryViewDto> categoryViewDtoList = this.categoryService.getCategoriesByProductCount();
        String json = this.gson.toJson(categoryViewDtoList);
        System.out.println(json);
    }

    /**
     * Query 4 – Users and Products
     */
    public void usersAndProducts() {
        UserProductViewDto userProductViewDto = this.userService.getUsersAndTheirProducts();
        String json = this.gson.toJson(userProductViewDto);
        System.out.println(json);
    }
}


