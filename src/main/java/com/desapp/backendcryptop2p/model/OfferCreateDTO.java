package com.desapp.backendcryptop2p.model;

import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.Setter;

public class OfferCreateDTO {

    @Enumerated
    @Getter @Setter private OperationType type;
    @Getter @Setter private Double nominalValue ;
    @Enumerated
    @Getter @Setter private CryptoType cryptoType;
    @Getter @Setter private String email;
}