package com.desapp.backendcryptop2p.dto;
import java.time.LocalDateTime;

import com.desapp.backendcryptop2p.model.CryptoType;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Hidden

public class CryptoActiveDTO {
    private int id;
    private CryptoType symbol;
    private Double price;
    private LocalDateTime createAt;
}