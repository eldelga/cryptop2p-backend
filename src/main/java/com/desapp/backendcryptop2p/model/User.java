package com.desapp.backendcryptop2p.model;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "appUser")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    @Column(unique = true)
    private String email;
    private String password;
    private String walletAddress;
    private String cvu;
    Integer sucessfulOperations ;
    Integer totalOperations;
    Integer rate;



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