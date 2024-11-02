package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {
    void save(User user);

    void delete(Long id);

    void update(User user);

    User findById(Long Id);

    List<User> getAllUsers();
}
