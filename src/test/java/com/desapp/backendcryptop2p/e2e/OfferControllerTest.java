
package com.desapp.backendcryptop2p.e2e;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc ;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.desapp.backendcryptop2p.security.AuthResponse;
import com.desapp.backendcryptop2p.service.CryptoActiveService;
import com.fasterxml.jackson.databind.ObjectMapper; 

@SpringBootTest
@AutoConfigureMockMvc
class OfferControllerTest {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CryptoActiveService cryptoActiveService ;

    @Autowired
    private WebApplicationContext context ;

    private AuthResponse authResponse;


    @BeforeEach
    public void setUp() throws Exception {
        String  requestBody = "{\"email\":\"user@domain.com\", \"password\": \"password\"}";
            MvcResult result =  mockMvc.perform(post("/auth/login")
            .contentType("application/json")
            .content(requestBody))
            .andExpect(status().isOk())
            .andReturn();
            String postResponse = result.getResponse().getContentAsString();
            ObjectMapper objectMapper = new ObjectMapper();
            this.authResponse = objectMapper.readValue(postResponse, AuthResponse.class);
    }
    
    @Test
    public void shouldReturn404() throws Exception {
        System.out.println(this.authResponse.getAccessToken());
              mockMvc.perform(MockMvcRequestBuilders.get("/obj/123"))
                  .andExpect(MockMvcResultMatchers.status().is(HttpStatus.UNAUTHORIZED.value()));
    }

}




        // MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    
        // private MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();


        // val assetName = "ALICEUSDT"

       // Mockito
       //     .when(exchangeService.getCryptoAssetPrice(assetName))
       //     .thenReturn(1.31200000);
  //  }

  
   // @Test */
   // public void shouldThrow200StatusWhenValidAssetIsCreated() throws Exception {
   // mockMvc.perform(post("/assets")
   //         .contentType("application/json")
   //         .param("assetName", "ALICEUSDT"))
   //         .andExpect(status().isOk());
   // }

