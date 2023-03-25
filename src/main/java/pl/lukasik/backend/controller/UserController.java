package pl.lukasik.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukasik.backend.service.UserService;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/load")
    public ResponseEntity<String> loadUsers() {
        try {
            userService.loadUsersFromFile(".\\data\\examples\\user1.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Users loaded successfully");
    }
}
