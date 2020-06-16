package edu.tec.ic6821.app.security;

public interface AuthenticationService {
    String authenticate(String username, String password);
}
