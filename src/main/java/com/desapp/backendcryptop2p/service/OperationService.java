package com.desapp.backendcryptop2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.model.Offer;
import com.desapp.backendcryptop2p.model.Operation;
import com.desapp.backendcryptop2p.model.OperationReadDTO;
import com.desapp.backendcryptop2p.model.OperationType;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.persistence.OperationRepository;

@Service
public class OperationService {
    
    @Autowired
    private OperationRepository operationRepository ;

    @Autowired
    private MapperComponent modelMapper;

    @Autowired
    private UserService userService;

    public OperationReadDTO createFromOffer(Offer offer,User seller, User buyer){
        Operation newOperation = new Operation();

        if (offer.getType() == OperationType.SALE){
            newOperation.setUserSeller(seller);
            newOperation.setUserBuyer(buyer);
        }else{
            newOperation.setUserSeller(seller);
            newOperation.setUserBuyer(buyer);
        }

        newOperation.setCryptoType(offer.getCryptoType());
        newOperation.setNominalValue(offer.getNominalValue());
        newOperation.setCryptoValue(offer.getCryptoValue());
        newOperation.setPesosQuotation(offer.getPesosQuotation());
        newOperation.setCryptoType(offer.getCryptoType());

        this.operationRepository.save(newOperation);

        return( this.modelMapper.to(newOperation, OperationReadDTO.class));
        
    }

    public OperationReadDTO sendAmount(Integer operationId) {
        Operation operation = this.operationRepository.getReferenceById(operationId);
        operation.sendAmount();
        operation.updateStatus();
        User seller = operation.getUserSeller();
        seller.updateSuccededOperations();
        operation = this.operationRepository.save(operation);
        userService.update(seller);
        return( this.modelMapper.to(operation, OperationReadDTO.class));
    }

    public OperationReadDTO sendCryptos(Integer operationId) {
        Operation operation = this.operationRepository.getReferenceById(operationId);
        operation.receiveCrypto();
        operation.updateStatus();
        User buyer = operation.getUserBuyer();
        buyer.updateSuccededOperations();
        operation = this.operationRepository.save(operation);
        userService.update(buyer);
        return( this.modelMapper.to(operation, OperationReadDTO.class));
    }
    
}
