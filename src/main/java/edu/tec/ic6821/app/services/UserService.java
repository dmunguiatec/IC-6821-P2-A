package edu.tec.ic6821.app.services;

import edu.tec.ic6821.app.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> create(String username, String password);
}
