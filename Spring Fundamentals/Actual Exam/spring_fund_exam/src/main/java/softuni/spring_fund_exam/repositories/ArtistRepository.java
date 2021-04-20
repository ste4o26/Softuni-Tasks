package softuni.spring_fund_exam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.spring_fund_exam.model.entities.ArtistEntity;
import softuni.spring_fund_exam.model.entities.enums.BandName;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, String> {

    Optional<ArtistEntity> findByName(BandName name);
}
