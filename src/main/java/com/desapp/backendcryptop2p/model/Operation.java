package com.desapp.backendcryptop2p.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
@Data
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime createDate;
    @Enumerated
    private OperationType type;
    @Enumerated
    private CryptoType cryptoType ; 
    
    private Double nominalValue ;
    private Double cryptoValue;
    private Double pesosQuotation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_origin")
    private User userOrigin;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_destination")
    private User userDestination;
    private TransactionStatus operationStatus;
    private currencyStatus cryptoStatus ;
    private currencyStatus amountStatus ;
    
}
