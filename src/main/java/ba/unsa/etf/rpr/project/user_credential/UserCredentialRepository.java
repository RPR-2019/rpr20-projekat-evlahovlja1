package ba.unsa.etf.rpr.project.user_credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
    @Query("SELECT uc FROM UserCredential uc WHERE uc.username=?1")
    Optional<UserCredential> findUserCredentialByUsername(String username);
}
