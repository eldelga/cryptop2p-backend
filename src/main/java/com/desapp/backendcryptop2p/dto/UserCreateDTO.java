
package com.desapp.backendcryptop2p.dto;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

public class UserCreateDTO {
   
    @Size(min = 3, max = 30)
    @Getter @Setter private String firstName;
    // @Size(min = 3, max = 30)
    @Getter @Setter private String lastName;
    // @Size(min = 10, max = 30)
    @Getter @Setter private String address;
    // @Email
    @Getter @Setter private String email;
    // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "La contraseña debe tener al menos 1 minúscula, 1 mayúscula, 1 carácter especial y un mínimo de 6 caracteres")
    @Getter @Setter private String password;
    // @Size(min = 8, max = 8)
    @Getter   @Setter private String walletAddress;
    // @Size(min = 20, max = 20)
    @Getter   @Setter private String cvu;
    
}