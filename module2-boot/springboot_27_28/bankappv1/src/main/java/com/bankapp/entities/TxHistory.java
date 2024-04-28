package com.bankapp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="tx_history_table")
public class TxHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int acc1;
    private int acc2;
    private String txType;
    private String clerkName;
    private LocalDateTime localDateTime;

    public TxHistory(int acc1, int acc2, String txType, String clerkName, LocalDateTime localDateTime) {
        this.acc1 = acc1;
        this.acc2 = acc2;
        this.txType = txType;
        this.clerkName = clerkName;
        this.localDateTime = localDateTime;
    }
}
