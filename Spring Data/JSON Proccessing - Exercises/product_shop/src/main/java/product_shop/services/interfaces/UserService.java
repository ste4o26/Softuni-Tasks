package product_shop.services.interfaces;

import product_shop.domain.dtos.SellerDetailViewDto;
import product_shop.domain.dtos.UserSeedDto;
import product_shop.domain.dtos.export.UserDetailViewDto;
import product_shop.domain.dtos.export.UserProductViewDto;

import java.util.List;

public interface UserService {
    String seedUsers(List<UserSeedDto> userSeedDtoList);

    List<SellerDetailViewDto> getSellersWithSuccessfullySoldProducts();

    UserProductViewDto getUsersAndTheirProducts();
}
