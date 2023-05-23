package com.desapp.backendcryptop2p.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.desapp.backendcryptop2p.service.CryptoActiveService;

@Configuration
@EnableScheduling
public class ScheduledTaskConfig {

  @Autowired
  private CryptoActiveService cryptoActiveService;

  private final long SEGUNDO = 1000;   
  private final long MINUTO = SEGUNDO * 60;   
  private final long HORA = MINUTO * 60;
  private final long TEN_MINUTES = MINUTO * 10 ;

  @Scheduled(fixedDelay = TEN_MINUTES)   
  public void verifyPerMinute() {    
    System.out.println("CryptoUpdated"); 
    this.cryptoActiveService.updateCryptos();
  }
}
