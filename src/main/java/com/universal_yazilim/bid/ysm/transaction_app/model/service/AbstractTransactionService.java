package com.universal_yazilim.bid.ysm.transaction_app.model.service;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import com.universal_yazilim.bid.ysm.transaction_app.model.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractTransactionService implements EntityService<Transaction,Integer>
{
    @Autowired
    protected TransactionRepository transactionRepository;

    public abstract List<Transaction> findAllByUserID(Integer userID);

}
