package com.desapp.backendcryptop2p.model;
import lombok.Data;
import javax.persistence.Enumerated;

@Data
public class OfferCreateDTO {
    @Enumerated
    private OperationType type;
    private Double nominalValue ;
    @Enumerated
    private CryptoType cryptoType;
    private Double cryptoValue;
}