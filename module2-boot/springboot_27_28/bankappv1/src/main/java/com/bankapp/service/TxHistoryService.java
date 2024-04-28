package com.bankapp.service;

import com.bankapp.entities.TxHistory;

import java.util.List;

public interface TxHistoryService {
    public List<TxHistory>getAll();
    public List<TxHistory> findByAcc1OrAcc2(int acc1, int acc2);
    public void addTxHistory(TxHistory txHistory);

}
