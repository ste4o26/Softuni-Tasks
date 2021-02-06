package softuni.library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.library.models.entities.Character;

import java.util.List;
import java.util.Optional;

//Todo imort character
@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    @Query(value = "SELECT c FROM characters AS c " +
            "WHERE c.age >= 32 " +
            "ORDER BY c.book.name ASC, " +
            "c.lastName DESC, " +
            "c.age ASC")
    Optional<List<Character>> exportCharacters();
}