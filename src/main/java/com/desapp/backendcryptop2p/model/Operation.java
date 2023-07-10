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

import com.fasterxml.jackson.databind.cfg.CoercionInputShape;

import lombok.Data;
@Data
@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime createdAt;
    @Enumerated
    private CryptoType cryptoType ; 
    
    private Double nominalValue ;
    private Double cryptoValue;
    private Double pesosQuotation;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_seller")
    private User userSeller;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_buyer")
    private User userBuyer;
    private TransactionStatus operationStatus;
    private CurrencyStatus cryptoStatus ;
    private CurrencyStatus amountStatus ;

    public Operation(){
        this.cryptoStatus = CurrencyStatus.WAITING ;
        this.amountStatus = CurrencyStatus.WAITING ;
        this.operationStatus = TransactionStatus.OPEN ;
        this.createdAt = LocalDateTime.now();
    }

    public void sendAmount() {
        this.amountStatus = CurrencyStatus.SENDED;
        this.updateStatus();
    }
    
    public void receiveCrypto() {
        this.cryptoStatus = CurrencyStatus.RECEIVED;
        this.updateStatus();
    }

    public void updateStatus(){
        if( this.amountStatus == CurrencyStatus.SENDED && this.cryptoStatus == CurrencyStatus.RECEIVED ){
            this.operationStatus = TransactionStatus.CLOSED ;
        }
    }


}
