package com.example.UserApp.Controllers;

import com.example.UserApp.Models.User;
import com.example.UserApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        try {
            return userService.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        try {
            return userService.update(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @DeleteMapping("/{Id}")
    public String deleteUser(@PathVariable int Id) {
        try {
            return userService.delete(Id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @GetMapping("/{Id}")
    public Optional<User> getUser(@PathVariable int Id) {
        try {
            return userService.getById(Id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
