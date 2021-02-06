package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query(value = "SELECT c FROM cars AS c " +
            "ORDER BY c.pictures.size DESC, " +
            "c.make ASC")
    Optional<List<Car>> exportCars();
}
