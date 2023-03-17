package data.repositories;

import data.models.User;
import java.util.List;

public interface UserRepository {
    User getUserByUsername(String username);
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(String username, User updatedUser);
    void deleteUser(String username);
}