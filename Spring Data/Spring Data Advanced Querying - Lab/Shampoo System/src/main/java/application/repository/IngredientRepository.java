package application.repository;

import application.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query(value = "SELECT i FROM ingredients AS i " +
            "WHERE i.name LIKE :prefix%")
    List<Ingredient> fetchByNameStartsWith(@Param(value = "prefix") String prefix);

    @Query(value = "SELECT i FROM ingredients AS i " +
            "WHERE i.name IN :names " +
            "ORDER BY i.price ASC")
    List<Ingredient> fetchWithNamesOrderByPrice(@Param(value = "names") List<String> names);

    //Whenever trying to update/delete(DML) i must put @Modifying over the query
    //and @Transactional in the method which call this particular repository method!
    @Modifying
    @Query(value = "DELETE FROM ingredients AS i " +
            "WHERE i.name = :ingredientName")
    Integer deleteByName(@Param(value = "ingredientName") String ingredientName);

    @Modifying
    @Query(value = "UPDATE ingredients AS i " +
            "SET i.price = i.price * 1.10")
    Integer updateAllPricesBy10Percentages();

    @Modifying
    @Query(value = "UPDATE ingredients AS i " +
            "SET i.price = i.price * 1.10 " +
            "WHERE i.name IN :ingredientsNames")
    Integer updateAllWithNameIn(@Param(value = "ingredientsNames") List<String> ingredientsNames);
}
