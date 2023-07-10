package com.desapp.backendcryptop2p.model;

import javax.persistence.Enumerated;

import lombok.Data;


@Data
public class OfferReadDTO {
    Integer id ;
    @Enumerated
    private OperationType type;
    private Double nominalValue ;
    @Enumerated
    private CryptoType cryptoType;
    private boolean isActive;
    private UserReadDTO createdBy;
}