import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void displayUser(int id) {
        String user = userRepository.findUserById(id);
        System.out.println(user);
    }
}