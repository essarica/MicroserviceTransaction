package com.universal_yazilim.bid.ysm.transaction_app.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@SequenceGenerator(name = "TRANSACTIONS_SEQUENCE", sequenceName = "TRANSACTIONS_SEQ", initialValue = 1, allocationSize = 1)
@Table(name = "TRANSACTIONS")
@Entity
public class Transaction
{

    @Column(name = "TRANSACTION_ID",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTIONS_SEQUENCE")
    @Id
    private Integer transactionID;

    @Column(name = "PRODUCT_ID" ,nullable = false)
    private Integer  productID;

    @Column(name = "USER_ID" ,nullable = false)
    private Integer userID;

    @Column(name = "TRANSACTION_TIME" ,nullable =  false)
    private Date transactionTime;
}
