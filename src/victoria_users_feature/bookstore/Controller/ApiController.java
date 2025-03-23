package com.example.bookstore.Controller;

import com.example.bookstore.Models.User;
import com.example.bookstore.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage() {
        return "Bookstore";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user) {
        userRepo.save(user);
        return "User Saved";
    }

    //method to return user data based on username
    @GetMapping(value = "/users/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userRepo.findByUsername(username);

    }

    //method to update user field given username (except mail)
    @PutMapping(value = "update/{username}")
    public String updateUser(@PathVariable String username, @RequestBody User user) {
        Optional<User> existingUser = userRepo.findByUsername(username);

        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();

            //updating only fields that have a value and are not mailing fields
            if (user.getFirstName() != null) updatedUser.setFirstName(user.getFirstName());
            if (user.getLastName() != null) updatedUser.setLastName(user.getLastName());
            if (user.getPassword() != null) updatedUser.setPassword(user.getPassword());
            if (user.getCreditCard() != null) updatedUser.setCreditCard(user.getCreditCard());

            userRepo.save(updatedUser);
            return "User Updated";
        }

        return "User Not Found";
    }

}
