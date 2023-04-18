package com.desapp.backendcryptop2p.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "appUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Integer id;
    @Size(min = 3, max = 30)
    @Getter @Setter private String firstName;
    @Size(min = 3, max = 30)
    @Getter @Setter private String lastName;
    @Size(min = 10, max = 30)
    @Getter @Setter private String address;
    @Email
    @Getter @Setter private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$", message = "La contraseña debe tener al menos 1 minúscula, 1 mayúscula, 1 carácter especial y un mínimo de 6 caracteres")
    @Getter @Setter private String password;
    @Getter  private Integer rate ;
    @Size(min = 8, max = 8)
    @Getter  private String walletAddress;
    @Size(min = 20, max = 20)
    @Getter  private String cvu;
    @Getter Integer sucessfulOperations ;
    @Getter Integer totalOperations;

    public User() {}

	public User(String firstName,String lastName,String address,String email,String password,String walletAddress) {
		this.firstName = firstName ; 
		this.lastName = lastName ;
		this.address = address ;
		this.email = email ;
		this.password = password ;
        this.walletAddress = walletAddress ;
        this.rate = 0 ;
        this.sucessfulOperations = 0 ;
        this.totalOperations = 0 ;
	}

}