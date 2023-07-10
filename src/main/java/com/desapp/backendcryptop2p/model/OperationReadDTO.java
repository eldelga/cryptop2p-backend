package com.desapp.backendcryptop2p.model;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class OperationReadDTO {
      
    private int id;
    private LocalDateTime createdAt;
    private CryptoType cryptoType ; 
    private Double nominalValue ;
    private Double cryptoValue;
    private Double pesosQuotation;
    private UserReadDTO userSeller;
    private UserReadDTO userBuyer;
    private TransactionStatus operationStatus;
    private CurrencyStatus cryptoStatus ;
    private CurrencyStatus amountStatus ;
}
