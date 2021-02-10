package ba.unsa.etf.rpr.project.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.firstname = ?1 AND u.lastname = ?2")
    Optional<User> findUserByNameAndLastname(String name, String lastname);
}
