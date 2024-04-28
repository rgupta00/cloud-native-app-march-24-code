package com.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="card_table")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String cardNumber;
    private String type;
    private LocalDate issueDate;

    public Card(String cardNumber, String type, LocalDate issueDate) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.issueDate = issueDate;
    }
}
