package product_shop.reositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product_shop.domain.entities.Product;
import product_shop.domain.entities.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM users AS u " +
            "INNER JOIN products AS s_p " +
            "ON u.id = s_p.seller.id " +
            "INNER JOIN products AS b_p " +
            "ON u.id = b_p.buyer.id " +
            "GROUP BY u.id " +
            "ORDER BY u.lastName ASC, " +
            "u.firstName ASC")
    Optional<List<User>> findAllUsersWithAtLeastOneSoldItem();
}
