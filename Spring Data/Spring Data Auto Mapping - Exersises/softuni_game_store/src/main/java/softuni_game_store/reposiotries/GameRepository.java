package softuni_game_store.reposiotries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni_game_store.domain.entities.Game;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game, String> {
    Optional<Game> findByTitle(String title);

    List<Game> findByUsers_Email(String email);

    //Vqrno e no ne bachka ne znam zashto :/
//    @Query(value = "SELECT g FROM games AS g "+
//            "JOIN users AS u " +
//            "WHERE u.email = :email")
//    List<Game> findAllByUserEmail(@Param(value = "email") String email);
}
