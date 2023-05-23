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

@Entity
@Data
public class Offer {

    public Offer(){
        this.isActive = true ;
        this.createDate = LocalDateTime.now() ;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_created_by")
    private User createdBy;

    // private Double amountInPesos ;
    private Double nominalValue ;
    private Double cryptoValue;
    private Double pesosQuotation;

    @Enumerated
    private OperationType type;

    @Enumerated
    private CryptoType cryptoType ; 

    private LocalDateTime createDate;

    private boolean isActive;

    public double getAmountInPesos(){
        return this.getPesosQuotation() * this.getCryptoValue();
    }

}
