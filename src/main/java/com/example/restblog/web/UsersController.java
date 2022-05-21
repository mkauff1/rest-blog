package com.example.restblog.web;

import com.example.restblog.data.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/users", headers = "Accept=application/json")
public class UsersController {

    List<User> users = new ArrayList<>();

    @GetMapping
    public List<User> getAll() {
        users.add(new User("mkauff", "mkauff@gmail.com", "password"));
        users.add(new User("ryGuy", "ryGuy@gmail.com", "RysTheMan"));
        users.add(new User("casey1", "casey1@gmail.com", "mrRogers"));

        return users;
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable Long id) {
        for (User user : getAll()) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return new User();
    }

    @GetMapping("username")
    public User getByUsername(@RequestParam String username){
        System.out.println("Getting user with username: " + username);
        for(User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        };
        return null;
    }

    @GetMapping("email")
    public User getByEmail(@RequestParam String email) {
        System.out.println("Getting user with email: " + email);
        return null;
    }

    @PostMapping
    public void createUser(@RequestBody User userToAdd){
        System.out.println(userToAdd);
    }

    @PutMapping("{id}")
    public void updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        for (User user : users){
            if (user.getId() == (id)){
                user.setUsername(updatedUser.getUsername());
                user.setEmail(updatedUser.getEmail());
                user.setPassword(updatedUser.getPassword());
                user.setCreatedAt(updatedUser.getCreatedAt());
                user.setRole(updatedUser.getRole());
            }
        }
    }

    //
    private void updatePassword(@PathVariable Long id, @RequestParam(required = false) String oldPassword, @Valid @Size(min = 3) @RequestParam String newPassword) {
        System.out.println("Updating user password");
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        System.out.println("Deleting user with id: " + id);
    }
}
