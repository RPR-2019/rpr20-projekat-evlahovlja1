package ba.unsa.etf.rpr.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(
            consumes = "application/json",
            produces = "text/plain"
    )
    public String registerUser(@RequestBody User user) {
        this.userService.addNewUser(user);
        return String.valueOf(user.getId());
    }
}
