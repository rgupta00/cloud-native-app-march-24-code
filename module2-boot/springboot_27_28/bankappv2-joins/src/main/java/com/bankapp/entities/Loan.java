package com.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="loan_table")
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lid;
    private String loanNumber;
    private String type;
    private LocalDate issueDate;
    private BigDecimal amount;

    public Loan(String loanNumber, String type, LocalDate issueDate, BigDecimal amount) {
        this.loanNumber = loanNumber;
        this.type = type;
        this.issueDate = issueDate;
        this.amount = amount;
    }
}
