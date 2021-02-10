//package ba.unsa.etf.rpr.project.user;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository userRepository) {
//        return args -> {
//            User a = new User("Elvir", "Vlahovljak", 'M', LocalDate.of(2000, 1, 24), "Sarajevo", true, "ETF", "C#", "nista posebno");
//            userRepository.saveAll(List.of(a));
//        };
//    }
//}
