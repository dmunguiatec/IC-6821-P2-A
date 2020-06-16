package edu.tec.ic6821.app.users;

import edu.tec.ic6821.app.users.User;

import java.util.Optional;

public interface UserService {
    Optional<User> create(String username, String password);
}
