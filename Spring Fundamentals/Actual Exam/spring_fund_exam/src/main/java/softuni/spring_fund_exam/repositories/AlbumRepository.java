package softuni.spring_fund_exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.spring_fund_exam.model.entities.AlbumEntity;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity, String> {

    @Query("SELECT SUM(a.copies) FROM albums AS a")
    Optional<Integer> findAllAlbumsTotalCopies();
}
