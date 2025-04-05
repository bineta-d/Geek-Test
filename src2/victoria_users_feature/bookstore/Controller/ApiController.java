package com.example.bookstore.Controller;

import com.example.bookstore.Models.CreditCard;
import com.example.bookstore.Models.User;
import com.example.bookstore.Repo.UserRepo;
import com.example.bookstore.Repo.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CreditCardRepo creditCardRepo;

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

            // Updating only fields that have a value and are not mailing fields
            if (user.getFirstName() != null) updatedUser.setFirstName(user.getFirstName());
            if (user.getLastName() != null) updatedUser.setLastName(user.getLastName());
            if (user.getPassword() != null) updatedUser.setPassword(user.getPassword());

            // Since the credit card is linked through a One-to-One relationship, we can update the credit card like this
            if (user.getCreditCard() != null) {
                updatedUser.setCreditCard(user.getCreditCard());  // Link the credit card to the user
            }

            userRepo.save(updatedUser);
            return "User Updated";
        }

        return "User Not Found";
    }


    @PostMapping(value = "/saveCreditCard/{username}")
    public String saveCreditCard(@PathVariable String username, @RequestBody CreditCard creditCard) {
        Optional<User> optionalUser = userRepo.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            // Check if the user already has a credit card
            if (user.getCreditCard() != null) {
                return "User already has a credit card. Update instead of adding a new one.";
            }

            // Link the credit card to the user
            user.setCreditCard(creditCard);
            creditCard.setUser(user);

            // Save only if necessary
            creditCardRepo.save(creditCard);
            userRepo.save(user);

            return "Credit Card Saved for User: " + username;
        } else {
            return "User Not Found";
        }
    }

}
