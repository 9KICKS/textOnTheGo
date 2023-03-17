package services;

import data.models.User;
import data.repositories.UserRepository;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(String username, User updatedUser) {
        userRepository.updateUser(username, updatedUser);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteUser(username);
    }
}