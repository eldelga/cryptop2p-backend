package com.desapp.backendcryptop2p.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import com.desapp.backendcryptop2p.component.MapperComponent;
import com.desapp.backendcryptop2p.model.CryptoActive;
import com.desapp.backendcryptop2p.model.CryptoType;
import com.desapp.backendcryptop2p.persistence.CryptoActiveRepository;
import com.desapp.backendcryptop2p.dto.CryptoActiveDTO;

@Service
public class CryptoActiveService {
    
    @Autowired
    private CryptoActiveRepository cryptoActiveRepository;

    @Autowired
    private MapperComponent modelMapper;
    
   
    public List<CryptoActiveDTO> getAll() {
        return this.modelMapper.toList(this.cryptoActiveRepository.findAll(), CryptoActiveDTO.class);
    }

    public List<CryptoActiveDTO> findMaxdates(){
        return this.modelMapper.toList(this.cryptoActiveRepository.getLastUpdated(), CryptoActiveDTO.class);
    }

    public void create(CryptoActiveDTO cryptoActiveDTO) {
        CryptoActive newCryptoActive = modelMapper.to(cryptoActiveDTO,CryptoActive.class) ;
        this.cryptoActiveRepository.save(newCryptoActive);
    }

    public CryptoActive getLastBySymbol(CryptoType symbol){
        return this.cryptoActiveRepository.getLastBySymbol(symbol);
    }

    public void updateCryptos() {
        Arrays.asList(CryptoType.values()).forEach(symbol -> {
            String uri = String.format("https://api1.binance.com/api/v3/ticker/price?symbol=%s",symbol);
            RestTemplate restTemplate = new RestTemplate();
            CryptoActive cryptoActive = restTemplate.getForObject(uri, CryptoActive.class);
            this.cryptoActiveRepository.save(cryptoActive);
        });
    
    }

}
