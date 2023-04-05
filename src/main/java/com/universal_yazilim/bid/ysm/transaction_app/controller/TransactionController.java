package com.universal_yazilim.bid.ysm.transaction_app.controller;

import com.universal_yazilim.bid.ysm.transaction_app.model.entity.Transaction;
import com.universal_yazilim.bid.ysm.transaction_app.model.service.AbstractTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
@RequestMapping("api/transaction")
@RestController
public class TransactionController
{
    @Autowired
    private AbstractTransactionService transactionService;


    @GetMapping("user/{id}")
    public ResponseEntity<List<Transaction>> getTransactionsOfUser(@PathVariable(name = "id") Integer userID)
    {
        List<Transaction> transactionList = transactionService.findAllByUserID(userID);
        return ResponseEntity.ok(transactionList);
    }

    @GetMapping("{id}")
    public ResponseEntity findByID(@PathVariable(name = "id") Integer transactionID)
    {
        transactionService.findByID(transactionID);

        return ResponseEntity.ok("transactionID: " + transactionID + " has been selected.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteByID(@PathVariable(name = "id") Integer transactionID)
    {
        transactionService.deleteByID(transactionID);

        return ResponseEntity.ok("transactionID: " + transactionID + " has been deleted.");
    }

    @PostMapping
    public ResponseEntity<Transaction> save(@RequestBody Transaction transaction)
    {
        transaction.setTransactionTime(new Date());

        Transaction savedTransaction = transactionService.save(transaction);

        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAll()
    {
        List<Transaction> transactionList = transactionService.getAll();

        return ResponseEntity.ok(transactionList);
    }

}


