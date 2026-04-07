import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import lt.donatasmart.playground.service.UserService;

@Component
public class UserHandler {

    private final UserService userService;

    @Autowired
    public UserHandler(UserService userService) {
        this.userService = userService;
    }
    
    // Add other methods here, e.g. to handle user requests
}