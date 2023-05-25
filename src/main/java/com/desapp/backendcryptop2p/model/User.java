package com.desapp.backendcryptop2p.model;


import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;



@Entity
@Table(name = "appUser")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter private Integer id;
    @Getter @Setter private String firstName;
    @Getter @Setter private String lastName;
    @Getter @Setter private String address;
    @Column(unique = true) @Getter @Setter private String email;
    @Getter @Setter private String password;
    @Getter  private String walletAddress;
    @Getter  private String cvu;
    @Getter @Setter Integer sucessfulOperations ;
    @Getter @Setter Integer totalOperations;
    @Getter Integer rate;


    public User() {}

	public User(String firstName,String lastName,String address,String email,String password,String walletAddress) {
		this.firstName = firstName ; 
		this.lastName = lastName ;
		this.address = address ;
		this.email = email ;
		this.password = password ;
        this.walletAddress = walletAddress ;
        this.sucessfulOperations = 0 ;
        this.totalOperations = 0 ;
	}

    public void updateRate() {
        if (this.getTotalOperations() == 0) {
            this.rate = 5;
        }else{
            this.rate = (this.getSucessfulOperations() / this.getTotalOperations() * 100) / 50 ;
        }
    }



}