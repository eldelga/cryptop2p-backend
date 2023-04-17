package com.desapp.backendcryptop2p.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@Configuration
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer"
)
public class SwaggerConfig implements WebMvcConfigurer {

   @Bean
   public OpenAPI customOpenAPI() {
       return new OpenAPI()
               .info(new Info()
                       .title("Backend")
                       .version("1.0.0")
                       .description("CryptoP2P Version 1.0")
                       .termsOfService("http://swagger.io/terms/"));
   }
}
