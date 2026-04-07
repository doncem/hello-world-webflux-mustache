import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import my.package.User;

@Component
public class UserHandler {
    private final UserService userService;

    @Autowired
    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}