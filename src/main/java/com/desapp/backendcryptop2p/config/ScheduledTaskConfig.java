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

  static private final long SECOND = 1000;   
  static private final long MINUTE = SECOND * 60;   
  static private final long TEN_MINUTES = MINUTE * 10 ;

  @Scheduled(fixedDelay = TEN_MINUTES)   
  public void verifyPerMinute() {    
    this.cryptoActiveService.updateCryptos();
  }
}
