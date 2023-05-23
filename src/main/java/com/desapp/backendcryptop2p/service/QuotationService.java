package com.desapp.backendcryptop2p.service;

import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.model.Quotation;

@Service
public class QuotationService {
    public Quotation getQuotation(){
        Quotation newQuotation = new Quotation();
        newQuotation.setCompra(233.59);
        newQuotation.setVenta(243.59);
        newQuotation.setAgencia("349");
        newQuotation.setNombre("Dolar Oficial");
        newQuotation.setVariacion("0");
        newQuotation.setVentaCero("TRUE");
        newQuotation.setDecimales(2);
        return newQuotation;
    }
}
