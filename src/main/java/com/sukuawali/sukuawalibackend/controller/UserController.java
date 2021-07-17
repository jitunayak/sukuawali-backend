package com.sukuawali.sukuawalibackend.controller;

import com.sukuawali.sukuawalibackend.models.User;
import com.sukuawali.sukuawalibackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Optional<User>> RegisterUser(@RequestBody User user) {
        User user1 = userService.saveUser(user);
        if (user1 != null) return new ResponseEntity(user1, HttpStatus.ACCEPTED);
        return new ResponseEntity("Could not save", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<Optional<User>> DeleteUser(@PathVariable Long userId) {
        Optional<User> user = userService.deleteUser(userId);
        if (!user.isEmpty()) return new ResponseEntity(user.get(), HttpStatus.ACCEPTED);
        return new ResponseEntity("Could not found the user", HttpStatus.BAD_REQUEST);
    }
}
