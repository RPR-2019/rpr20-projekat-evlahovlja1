package ba.unsa.etf.rpr.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByNameAndLastname(user.getFirstname(), user.getLastname());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("Firstname and lastname already taken!");
        }
        userRepository.save(user);
    }
}
