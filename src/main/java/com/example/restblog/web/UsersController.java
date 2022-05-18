package com.example.restblog.web;

import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.restblog.data.User.Role.ADMIN;
import static com.example.restblog.data.User.Role.USER;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAll() {
        users.add(new User(1L, "mkauff", "mkauff@gmail.com", "password", 010101, ADMIN);
        users.add(new User(2L, "ryGuy", "ryGuy@gmail.com", "RysTheMan", 2021, USER));
        users.add(new User(3L, "casey1", "casey1@gmail.com", "mrRogers", 2019, ADMIN));

        return users;
    }

    @GetMapping("{id}")
    public User getById(@PathVariable Long id) {
        for (User user : getAll()) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return new User();
    }

    @PostMapping
    public void createUser(@RequestBody User userToAdd){
        System.out.println(userToAdd);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        for (User user : users){
            if (user.getId().equals(id)){
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setCreatedAt(updatedUser.getCreatedAt());
                user.setRole(updatedUser.getRole());
            }
        }
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id: " + id);
    }
}
