package ba.unsa.etf.rpr.project.user_credential;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/cred")
public class UserCredentialController {
    private final UserCredentialService userCredentialService;

    @Autowired

    public UserCredentialController(UserCredentialService userCredentialService) {
        this.userCredentialService = userCredentialService;
    }

    @PostMapping(
            consumes = "application/json",
            produces = "text/plain"
    )
    public String registerUserCredential(@RequestBody UserCredential userCredential) {
        try {
            this.userCredentialService.addNewCredential(userCredential);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "OK";
    }
}
