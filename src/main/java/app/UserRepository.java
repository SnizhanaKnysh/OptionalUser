package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users = null;

    public void addUser(User user) {
        if (users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

    public Optional<User> findUserById(int id) {
        return users.stream()
            .filter(user -> user.getId() == id)
            .findFirst();
    }

    public Optional<User> findUserByEmail(String email) {
        return users.stream()
            .filter(user -> user.getEmail().equals(email))
            .findFirst();
    }

    public Optional<List<User>> findAllUsers(){
        return Optional.ofNullable(users);
    }
}
