package com.universal_yazilim.bid.ysm.transaction_app.model.repository;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Integer>
{
    Optional<List<Transaction>> findAllByUserID(Integer userID);
}

