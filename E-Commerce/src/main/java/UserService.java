import com.mongodb.client.MongoDatabase;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService(MongoDatabase database) {
        this.userDAO = new UserDAO(database);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public void addUser(User user) {
        userDAO.addUser(user);
    }

    public List<User> listUsers() {
        return userDAO.findAllUsers();
    }
}
