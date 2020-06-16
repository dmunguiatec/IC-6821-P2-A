package edu.tec.ic6821.app.daos;

import edu.tec.ic6821.app.model.User;

import java.util.Optional;

public interface UserDao {
    User create(User user);
    Boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}
