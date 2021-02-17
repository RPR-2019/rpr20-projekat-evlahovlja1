package ba.unsa.etf.rpr.project.user_credential;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserCredentialConfig {
    @Bean
    CommandLineRunner userCredentialBean(UserCredentialRepository userCredentialRepository) {
        return args -> {
            UserCredential userCredential = new UserCredential("test", "test");
            userCredentialRepository.save(userCredential);
        };
    }
}
