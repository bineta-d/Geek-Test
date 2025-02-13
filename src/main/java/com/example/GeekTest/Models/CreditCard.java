package com.example.GeekTest.Models;
import jakarta.persistence.*;
import java.util.Date;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "CreditCard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer creditCardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false, length = 20)
    private String cardNumber;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @Column(nullable = false, length = 4)
    private String cvv;

    private String billingAddress;

    // Getters and setters
}

