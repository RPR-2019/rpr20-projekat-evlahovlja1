package ba.unsa.etf.rpr.project.user_credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCredentialService {
    private final UserCredentialRepository userCredentialRepository;

    @Autowired

    public UserCredentialService(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    public void addNewCredential(UserCredential userCredential) {
        Optional<UserCredential> userCredentialOptional = userCredentialRepository.findUserCredentialByUsername(userCredential.getUsername());
        if (userCredentialOptional.isPresent()) {
            throw new IllegalArgumentException("Username already taken");
        }
        userCredentialRepository.save(userCredential);
    }
}
