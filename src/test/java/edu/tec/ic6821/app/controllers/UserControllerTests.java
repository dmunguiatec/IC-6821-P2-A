package edu.tec.ic6821.app.controllers;

import edu.tec.ic6821.app.config.security.JwtAuthEntryPoint;
import edu.tec.ic6821.app.config.security.JwtProvider;
import edu.tec.ic6821.app.model.User;
import edu.tec.ic6821.app.services.UserService;
import edu.tec.ic6821.app.services.impl.CustomUserDetailsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private CustomUserDetailsService customUserDetailsService;

    @MockBean
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @MockBean
    private JwtProvider jwtProvider;

    @Test
    public void givenValidCredentials_whenSignUp_thenSendUser() throws Exception {
        // given
        String username = "someuser";
        String password = "123queso";

        User newUser = new User(42L, username, passwordEncoder.encode(password));
        given(userService.create(username, password)).willReturn(Optional.of(newUser));

        String body = String.format("{\"username\": \"%s\", \"password\": \"%s\"}", username, password);

        // when ... then
        mvc.perform(post("/api/user/enrollment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(42)))
                .andExpect(jsonPath("$.username", is(username)))
                .andExpect(jsonPath("$.password").doesNotExist());
    }

    @Test
    public void givenEmptyUsername_whenSignUp_thenSendBadRequest() throws Exception {
        // given
        String body = "{\"password\": \"123queso\"}";

        // when ... then
        mvc.perform(post("/api/user/enrollment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void givenEmptyPassword_whenSignUp_thenSendBadRequest() throws Exception {
        // given
        String body = "{\"username\": \"someuser\"}";

        // when ... then
        mvc.perform(post("/api/user/enrollment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest());
    }
}
