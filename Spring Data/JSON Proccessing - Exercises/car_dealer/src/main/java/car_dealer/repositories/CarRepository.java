package car_dealer.repositories;

import car_dealer.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<List<Car>> findAllByMakeOrderByModelAscTravelledDistanceDesc(String make);

    @Query(value = "SELECT c FROM cars AS c " +
            "INNER JOIN c.parts AS p " +
            "GROUP BY c.id " +
            "ORDER BY c.id ASC ")
    Optional<List<Car>> findAllCarsWithTheirParts();
}
