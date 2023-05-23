package com.desapp.backendcryptop2p.model;

import javax.persistence.Enumerated;

import lombok.Data;


@Data
public class OfferReadDTO {
    @Enumerated
    private OperationType type;
    private Double nominalValue ;
    @Enumerated
    private CryptoType cryptoType;
    private User user;
}