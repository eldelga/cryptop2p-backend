package com.desapp.backendcryptop2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.dto.OfferCreateDTO;
import com.desapp.backendcryptop2p.dto.OfferReadDTO;
import com.desapp.backendcryptop2p.dto.OperationReadDTO;
import com.desapp.backendcryptop2p.model.Operation;
import com.desapp.backendcryptop2p.model.OperationType;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.CryptoActive;
import com.desapp.backendcryptop2p.model.ModelException;
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
    private OperationService operationService;

    @Autowired
    private QuotationService quotationService;

    public List<OfferReadDTO> getAll() {
        return this.modelMapper.toList(this.offerRepository.findAllByActive(true), OfferReadDTO.class);
    }

    public OfferReadDTO cancel(Integer id, String email) throws ModelException {
        User user = this.userService.getByEmail(email);
        Offer offer = offerRepository.getReferenceById(id) ;
        offer.cancel();
        offerRepository.save(offer);
        user.updateCancelledOperations();
        userService.update(user);
        return this.modelMapper.to(offer, OfferReadDTO.class);
    }

    public OfferCreateDTO create(OfferCreateDTO offerDTO,String email) throws ModelException {
        Offer newOffer = this.modelMapper.to(offerDTO, Offer.class);
        User user = this.userService.getByEmail(email);
        CryptoActive cryptoActiveLaseQuotation = this.cryptoActiveService.getLastBySymbol(offerDTO.getCryptoType());
        Double cryptoActiveLastQuotationValue = cryptoActiveLaseQuotation.getPrice();
        user.updateOperation();
        user.updateRate();
        newOffer.setCreatedBy(user);
        newOffer.setCryptoType(offerDTO.getCryptoType());
        newOffer.setCryptoValue(offerDTO.getCryptoValue());
        newOffer.setCryptoQuotation(cryptoActiveLastQuotationValue);
        newOffer.setPesosQuotation(quotationService.getQuotation().getVenta());
        newOffer.setNominalValue(offerDTO.getNominalValue());
        newOffer.checkData();
        this.offerRepository.save(newOffer) ;
        userService.update(user);
        return offerDTO;
    }

 
    public OperationReadDTO take(Integer offerId,String email) throws ModelException {
        Offer offer = offerRepository.getReferenceById(offerId) ;
        User userTaker = this.userService.getByEmail(email);
        User userOffer = offer.getCreatedBy();
        return this.operationService.createFromOffer(offer, userTaker, userOffer);
    }

    
}