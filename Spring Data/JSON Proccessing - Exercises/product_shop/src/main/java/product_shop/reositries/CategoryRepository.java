package product_shop.reositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product_shop.domain.entities.Category;
import product_shop.domain.entities.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
