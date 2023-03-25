package pl.lukasik.backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lukasik.backend.model.UserEntity;
import pl.lukasik.backend.model.UserList;
import pl.lukasik.backend.repository.UserRepository;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Async
    @Transactional
    public void loadUsersFromFile(String fileName) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);
        UserList users = mapper.readValue(file, UserList.class);
        List<UserEntity> userList = users.getUsers().stream()
                .map(user -> UserEntity.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .login(user.getLogin())
                        .build())
                .collect(Collectors.toList());
        Instant start = Instant.now();
        userRepository.saveAll(userList);
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end); // zwrócic obiekt statystyk
        System.out.println("Inserted " + userList.size() + " users in " + duration.getSeconds() + " seconds");
        }


    public Page<UserEntity> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public UserEntity getUserByName(String name) {
        return userRepository.findByName(name);
    }
}




