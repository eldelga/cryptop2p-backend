package com.desapp.backendcryptop2p.model;
import javax.persistence.*;



@Entity
@Table(name = "appUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String password;
    private Integer rate ;
    private String walletUrl;
    private Integer sucessfulOperations ;
    private Integer totalOperations;

    public User() {
        
    }

	public User(String firstName,String lastName,String address,String email,String password,String walletUrl) {
		this.firstName = firstName ; 
		this.lastName = lastName ;
		this.address = address ;
		this.email = email ;
		this.password = password ;
        this.walletUrl = walletUrl ;
        this.rate = 0 ;
        this.sucessfulOperations = 0 ;
        this.totalOperations = 0 ;
	}


    public Long getId() {
    	return this.id ;
    }
    
    public String getFirstName() {
    	return this.firstName ;
    }
    
    public String getLastName() {
    	return this.lastName ;
    }
    
    public String getEmail() {
    	return this.email ;
    }
    
    public String getPassword() {
    	return this.password ;
    }
    
    public String getAddress() {
    	return this.address;
    }

}