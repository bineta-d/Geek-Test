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

    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user) {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setStreet1(user.getStreet1());
        updatedUser.setStreet2(user.getStreet2());
        updatedUser.setCity(user.getCity());
        updatedUser.setState(user.getState());
        updatedUser.setZip(user.getZip());
        updatedUser.setCreditCard(user.getCreditCard());
        userRepo.save(updatedUser);
        return "User Updated";
    }

    //method to return user data based on username
    @GetMapping(value = "/users/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userRepo.findByUsername(username);

    }

}
