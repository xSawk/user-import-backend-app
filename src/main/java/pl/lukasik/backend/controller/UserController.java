package pl.lukasik.backend.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.lukasik.backend.controller.dto.UploadStatistic;
import pl.lukasik.backend.model.UserEntity;
import pl.lukasik.backend.service.UserService;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/load")
    public UploadStatistic loadUsers(@RequestParam("file") MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        try {
            return userService.loadUsersFromFile(originalFilename);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @GetMapping()
    public Page<UserEntity> getUsers(@PageableDefault(size = 25) Pageable pageable,
            @RequestParam(value = "searchValue", required = false) String searchValue) {
        return userService.getUsers(pageable, searchValue);
    }



}
