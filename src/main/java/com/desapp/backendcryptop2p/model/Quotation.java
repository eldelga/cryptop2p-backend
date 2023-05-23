package com.desapp.backendcryptop2p.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Quotation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private Double compra;
    private Double venta;
    private String agencia;
    private String variacion;
    private String ventaCero;
    private Integer decimales;
}
