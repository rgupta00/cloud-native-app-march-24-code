package com.bankapp.repo;

import com.bankapp.entities.TxHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface TxHistoryRepo extends JpaRepository<TxHistory, Integer> {
    public List<TxHistory> findByAcc1OrAcc2(int acc1, int acc2);
}
