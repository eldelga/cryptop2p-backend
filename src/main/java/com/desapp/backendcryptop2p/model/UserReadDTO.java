
package com.desapp.backendcryptop2p.model;
import lombok.Data;

@Data
public class UserReadDTO {
   
    private Integer id;
    private String email;
    // @Size(min = 3, max = 30)
    private String firstName;
    // @Size(min = 3, max = 30)
    private String lastName;
    // @Size(min = 10, max = 30)
    private String address;
    // @Email
    private Integer rate;

    private String reputation;
    
    
}