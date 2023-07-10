package com.desapp.backendcryptop2p.dto;

import javax.persistence.Enumerated;

import com.desapp.backendcryptop2p.model.CryptoType;
import com.desapp.backendcryptop2p.model.OperationType;

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