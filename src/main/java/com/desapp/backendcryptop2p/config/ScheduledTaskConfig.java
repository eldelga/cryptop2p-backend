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

  static private final long second = 1000;   
  static private final long minute = second * 60;   
  static private final long tenMinutes = minute * 10 ;

  @Scheduled(fixedDelay = tenMinutes)   
  public void verifyPerMinute() {    
    this.cryptoActiveService.updateCryptos();
  }
}
