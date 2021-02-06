package product_shop.reositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import product_shop.domain.entities.Category;
import product_shop.domain.entities.Product;
import product_shop.domain.entities.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<List<Product>> findAllByPriceIsBetweenAndBuyerIsNull(BigDecimal from, BigDecimal to);

    Optional<List<Product>> findAllBySeller(User seller);

    @Query(value = "SELECT p FROM products AS p " +
            "JOIN p.categories AS c " +
            "WHERE :category IN (c)")
    Optional<List<Product>> findAllByCategory(@Param(value = "category") Category category);

}
