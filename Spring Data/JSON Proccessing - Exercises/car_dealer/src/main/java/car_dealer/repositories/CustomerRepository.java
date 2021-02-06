package car_dealer.repositories;

import car_dealer.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "SELECT c FROM customers AS c " +
            "ORDER BY c.birthDate ASC, " +
            "c.youngDriver")
    Optional<List<Customer>> findAllOrderByBirthDateAndYoungDriver();

    @Query(value = "SELECT c FROM customers AS c " +
            "INNER JOIN c.sales AS s " +
            "GROUP BY c.id " +
            "HAVING s.size > 0 ")
    Optional<List<Customer>> findAllCustomersWithAtLeastOneSale();
}
