package com.desapp.backendcryptop2p.dto;
import lombok.Data;
import javax.persistence.Enumerated;

import com.desapp.backendcryptop2p.model.CryptoType;
import com.desapp.backendcryptop2p.model.OperationType;

@Data
public class OfferCreateDTO {
    @Enumerated
    private OperationType type;
    private Double nominalValue ;
    @Enumerated
    private CryptoType cryptoType;
    private Double cryptoValue;
}