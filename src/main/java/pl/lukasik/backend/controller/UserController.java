package pl.lukasik.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukasik.backend.model.UserEntity;
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
    public ResponseEntity<String> loadUsers(String path) {
        try {
            userService.loadUsersFromFile(".\\data\\examples\\user3.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("Users loaded successfully");
    }

    @GetMapping()
    public Page<UserEntity> getUsers(@PageableDefault(size = 25) Pageable pageable){
        return userService.getUsers(pageable);
    }

    @GetMapping("/{name}")
    public UserEntity getUserByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

}
