package product_shop.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_shop.domain.dtos.ProductDetailViewDto;
import product_shop.domain.dtos.SellerDetailViewDto;
import product_shop.domain.dtos.UserSeedDto;
import product_shop.domain.dtos.export.ProductItemDto;
import product_shop.domain.dtos.export.SoldProductsDetailDto;
import product_shop.domain.dtos.export.UserDetailViewDto;
import product_shop.domain.dtos.export.UserProductViewDto;
import product_shop.domain.entities.User;
import product_shop.reositries.ProductRepository;
import product_shop.reositries.UserRepository;
import product_shop.services.interfaces.UserService;
import product_shop.utils.interfaces.ValidatorUtil;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.productRepository = productRepository;
    }

    @Override
    public String seedUsers(List<UserSeedDto> userSeedDtoList) {
        if (this.userRepository.count() > 0) {
            return "Users data already filled!";
        }

        StringBuilder sb = new StringBuilder();
        userSeedDtoList
                .stream()
                .map(userDto -> this.modelMapper.map(userDto, User.class))
                .forEach(user -> {
                    if (this.validatorUtil.isValid(user)) {
                        sb.append(String.format("User %s successfully added.",
                                user.getLastName()));
                        sb.append(System.lineSeparator());

                        this.userRepository.saveAndFlush(user);

                    } else {
                        StringBuilder violationsString = new StringBuilder();
                        this.validatorUtil
                                .violations(user)
                                .forEach(violation -> violationsString.append(violation.getMessage()));
                        sb.append(violationsString.toString());
                        sb.append(System.lineSeparator());
                    }
                });

        return sb.toString();
    }


    @Override
    public List<SellerDetailViewDto> getSellersWithSuccessfullySoldProducts() {
        return this.userRepository
                .findAllUsersWithAtLeastOneSoldItem()
                .orElseThrow(() -> new IllegalStateException("No one has sold any product yet!"))
                .stream()
                .map(seller -> {
                    List<ProductDetailViewDto> productDetailViewDtoList = this.productRepository
                            .findAllBySeller(seller)
                            .orElseThrow(() -> new IllegalStateException(String
                                    .format("Seller %s does not exists!",
                                            seller.getLastName())))
                            .stream()
                            .map(product -> this.modelMapper.map(product, ProductDetailViewDto.class))
                            .collect(Collectors.toList());

                    SellerDetailViewDto sellerDetailViewDto = this.modelMapper.map(seller, SellerDetailViewDto.class);
                    sellerDetailViewDto.setProducts(productDetailViewDtoList);
                    return sellerDetailViewDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public UserProductViewDto getUsersAndTheirProducts() {
        List<UserDetailViewDto> userProducts = this.userRepository
                .findAllUsersWithAtLeastOneSoldItem()
                .orElseThrow(() -> new IllegalStateException("No users found!"))
                .stream()
                .map(this.getUserWithProducts())
                .collect(Collectors.toList());

        return new UserProductViewDto(userProducts.size(), userProducts);
    }

    private Function<User, UserDetailViewDto> getUserWithProducts() {
        Function<User, UserDetailViewDto> getUserWithHisProducts = user -> {
            List<ProductItemDto> products = this.productRepository
                    .findAllBySeller(user)
                    .orElseThrow(() -> new IllegalStateException(String
                            .format("No products found for user %s",
                                    user.getLastName())))
                    .stream()
                    .map(product -> this.modelMapper.map(product, ProductItemDto.class))
                    .collect(Collectors.toList());

            SoldProductsDetailDto soldProductsDetailDto
                    = new SoldProductsDetailDto(products.size(), products);

            UserDetailViewDto userDetailViewDto = this.modelMapper.map(user, UserDetailViewDto.class);
            userDetailViewDto.setSoldProducts(soldProductsDetailDto);

            return userDetailViewDto;
        };

        return getUserWithHisProducts;
    }
}
