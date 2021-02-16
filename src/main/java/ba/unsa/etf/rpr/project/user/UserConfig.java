package ba.unsa.etf.rpr.project.user;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User a = new User("test", "test", 'M', LocalDate.of(2000, 1, 1), "Sarajevi", true, "test", "C#", "test");
            userRepository.save(a);
        };
    }
}
