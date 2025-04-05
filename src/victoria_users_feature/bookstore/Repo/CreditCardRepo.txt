package com.example.bookstore.Repo;

import com.example.bookstore.Models.CreditCard;
import com.example.bookstore.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {

}
