package com.desapp.backendcryptop2p.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import lombok.Data;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity

public class CryptoActive implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
  
    @Enumerated(EnumType.STRING)
    private CryptoType symbol;
    private Double price;
    private LocalDateTime createAt;

    public CryptoActive(){
        this.createAt = LocalDateTime.now();
    }
}
