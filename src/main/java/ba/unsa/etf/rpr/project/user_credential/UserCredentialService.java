package ba.unsa.etf.rpr.project.user_credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCredentialService {
    private final UserCredentialRepository userCredentialRepository;

    @Autowired

    public UserCredentialService(UserCredentialRepository userCredentialRepository) {
        this.userCredentialRepository = userCredentialRepository;
    }

    public void addNewCredential(UserCredential userCredential) {
        userCredentialRepository.save(userCredential);
    }
}
