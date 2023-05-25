package com.desapp.backendcryptop2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.model.OfferCreateDTO;
import com.desapp.backendcryptop2p.model.OfferReadDTO;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.CryptoActive;
import com.desapp.backendcryptop2p.model.Offer;
import com.desapp.backendcryptop2p.persistence.OfferRepository;
import java.util.List;


@Service
public class OfferService {
    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private CryptoActiveService cryptoActiveService;

    @Autowired
    private MapperComponent modelMapper;

    @Autowired
    private QuotationService quotationService;

    public List<OfferReadDTO> getAll() {
        return this.modelMapper.toList(this.offerRepository.findAllByActive(true), OfferReadDTO.class);
    }


    public OfferCreateDTO create(OfferCreateDTO offerDTO) {
        Offer newOffer = this.modelMapper.to(offerDTO, Offer.class);
        User user = this.userService.getByEmail(offerDTO.getEmail());
        CryptoActive cryptoActive = this.cryptoActiveService.getLastBySymbol(offerDTO.getCryptoType());
        newOffer.setCreatedBy(user);
        newOffer.setCryptoType(offerDTO.getCryptoType());
        newOffer.setCryptoValue(cryptoActive.getPrice());
        newOffer.setPesosQuotation(quotationService.getQuotation().getVenta());
        newOffer.setNominalValue(offerDTO.getNominalValue());
        this.offerRepository.save(newOffer) ;
        return offerDTO;
    }
}