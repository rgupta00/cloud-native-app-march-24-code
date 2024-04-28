package com.bankapp.repo;

import com.bankapp.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepo extends JpaRepository<Card, Integer> {
}
