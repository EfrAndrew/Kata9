package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User findById(Long id);

    void delete(Long id);

    void save(String firstName, String lastName, String email);

    void update(Long id, String firstName, String lastName, String email);
}
