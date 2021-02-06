package product_shop.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import product_shop.domain.dtos.ProductViewDto;
import product_shop.domain.dtos.export.CategoryViewDto;
import product_shop.domain.entities.Category;
import product_shop.domain.entities.Product;
import product_shop.domain.entities.User;
import product_shop.utils.FileUtilImpl;
import product_shop.utils.ValidatorUtilImpl;
import product_shop.utils.interfaces.FileUtil;
import product_shop.utils.interfaces.ValidatorUtil;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

@Configuration
public class ApplicationBeanConfiguration {
    private FileUtil fileUtil;
    private Gson gson;
    private ModelMapper modelMapper;
    private Validator validator;
    private ValidatorUtil validatorUtil;

    @Bean
    public FileUtil fileUtil() {
        if (this.fileUtil == null) {
            this.fileUtil = new FileUtilImpl();
        }

        return this.fileUtil;
    }

    @Bean
    public Gson gson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setPrettyPrinting()
                    .create();
        }

        return this.gson;
    }

    @Bean
    public ModelMapper modelMapper() {
        if (this.modelMapper == null) {
            this.modelMapper = new ModelMapper();

            this.productViewDtoInitMappings();
            this.categoryViewDtoInitMappings();
        }

        return this.modelMapper;
    }

    @Bean
    public Validator validator() {
        if (this.validator == null) {
            this.validator = Validation
                    .byDefaultProvider()
                    .configure()
                    .buildValidatorFactory()
                    .getValidator();
        }

        return this.validator;
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        if (this.validatorUtil == null) {
            this.validatorUtil = new ValidatorUtilImpl(this.validator());
        }

        return this.validatorUtil;
    }

    private void productViewDtoInitMappings() {
        Converter<Product, String> converter = context -> {
            User seller = context.getSource().getSeller();
            return seller.getFirstName() == null ?
                    seller.getLastName() :
                    String.format("%s %s", seller.getFirstName(), seller.getLastName());
        };

        this.modelMapper
                .createTypeMap(Product.class, ProductViewDto.class)
                .addMappings(mapper -> {
                    mapper.using(converter);
                    mapper.map(source -> source, ProductViewDto::setSeller);
                });
    }

    private void categoryViewDtoInitMappings() {
        this.modelMapper
                .createTypeMap(Category.class, CategoryViewDto.class)
                .addMapping(Category::getName, CategoryViewDto::setCategory);
    }
}
