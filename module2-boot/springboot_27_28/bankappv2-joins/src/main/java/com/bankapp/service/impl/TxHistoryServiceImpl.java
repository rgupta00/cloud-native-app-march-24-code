package com.bankapp.service.impl;

import com.bankapp.entities.TxHistory;
import com.bankapp.repo.TxHistoryRepo;
import com.bankapp.service.TxHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@AllArgsConstructor
@Service
public class TxHistoryServiceImpl implements TxHistoryService {
    private final TxHistoryRepo txHistoryRepo;

    @Override
    public List<TxHistory> getAll() {
        return txHistoryRepo.findAll();
    }

    @Override
    public List<TxHistory> findByAcc1OrAcc2(int acc1, int acc2) {
        return txHistoryRepo.findByAcc1OrAcc2(acc1, acc2);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addTxHistory(TxHistory txHistory) {
        txHistoryRepo.save(txHistory);
    }
}
