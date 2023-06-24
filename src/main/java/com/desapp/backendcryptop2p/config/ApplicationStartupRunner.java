package com.desapp.backendcryptop2p.config;

import org.apache.commons.logging.LogFactory;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.desapp.backendcryptop2p.model.User;
import com.desapp.backendcryptop2p.model.UserCreateDTO;
import com.desapp.backendcryptop2p.service.UserService;


@Order(value=1)
@Component
public class ApplicationStartupRunner implements CommandLineRunner {
  protected final Log logger = LogFactory.getLog(getClass());

  @Autowired
  private UserService userService ;

  @Override
  public void run(String... args) throws Exception {
    logger.warn("ApplicationStartupRunner run method Started !!");
    UserCreateDTO uDTO = new UserCreateDTO();
    uDTO.setAddress("Fake 123");
    uDTO.setEmail("user@domain.com");
    uDTO.setFirstName("FirstName");
    uDTO.setLastName("Lasname");
    	//	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// String password = passwordEncoder.encode("password");
    uDTO.setPassword("password");
 
   
    // User user = userService.getByEmail(uDTO.getEmail());
    // if(user == null)
      userService.create(uDTO);
    // }
    
    

//     OfferCreateDTO oCreateDTO = new OfferCreateDTO();
//    oCreateDTO.setNominalValue(1000.00);
//     oCreateDTO.setCryptoType(CryptoType.AAVEUSDT);
//     oCreateDTO.setType(OperationType.SALE);
 //    oCreateDTO.setEmail("user@domain.com");
  //  offerService.create(oCreateDTO);

  }
}