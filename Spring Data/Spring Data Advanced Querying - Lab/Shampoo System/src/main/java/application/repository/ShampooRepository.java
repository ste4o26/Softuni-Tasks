package application.repository;

import application.domain.entities.Ingredient;
import application.domain.entities.Label;
import application.domain.entities.Shampoo;
import application.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    //have to ask where is better to put those queries... here directly in query
    //annotation or in separate static class with all custom queries for the given repository

    //IMPORTANT ... its better to keep the names of entity and table annotations exactly the same because
    //in custom queries i have to use the name that i have passed to the entity annotation!
    @Query(value = "SELECT s FROM shampoos AS s " +
            "WHERE s.size = :size " +
            "ORDER BY s.id ASC")
    List<Shampoo> fetchAllBySize(@Param(value = "size") Size size);


    @Query(value = "SELECT s FROM shampoos AS s " +
            "WHERE s.size = :size " +
            "OR s.label.id = :labelId " +
            "ORDER BY s.price ASC")
    List<Shampoo> fetchAllBySizeOrLabelIdOrderByPrice(@Param(value = "size") Size size, @Param(value = "labelId") Long labelId);


    @Query(value = "SELECT s FROM shampoos AS s " +
            "WHERE s.price > :price " +
            "ORDER BY s.price DESC")
    List<Shampoo> fetchAllByPrice(@Param(value = "price") BigDecimal price);


    //When i want to do some operations like comparing or checking if containing in between list of objects and collection of object,
    //which are property to this particular object repository i have to use join so the jpa and hibernate can execute the operation...
    //if i dont join they wont be able to see anything but the collection size itself
    @Query(value = "SELECT s FROM shampoos AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE i IN :ingredients")
    List<Shampoo> fetchShampoosByIngredients(@Param(value = "ingredients") List<Ingredient> ingredients);


    @Query(value = "SELECT COUNT(s.id) FROM shampoos AS s " +
            "WHERE s.price < :price")
    Integer countByPrice(@Param(value = "price") BigDecimal price);


    @Query(value = "SELECT s FROM shampoos AS s " +
            "WHERE s.ingredients.size < :ingredientsCount")
    List<Shampoo> fetchAllByIngredientsCountLowerThan(@Param(value = "ingredientsCount") Integer ingredientsCount);


    @Query(value = "SELECT SUM(i.price) FROM shampoos AS s " +
            "JOIN s.ingredients AS i " +
            "WHERE s.brand = :shampooBrand")
    BigDecimal fetchIngredientsPriceSumByName(@Param(value = "shampooBrand") String shampooBrand);
}
