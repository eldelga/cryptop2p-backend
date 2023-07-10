package com.desapp.backendcryptop2p.model;


import java.util.Collection;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class User  implements UserDetails { 

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
    Integer sucessfulOperations = 0 ;
    Integer totalOperations = 0 ;
    Integer cancelledOperations = 0;
    Integer rate;



	public User(String firstName,String lastName,String address,String email,String password,String walletAddress) {
		this.firstName = firstName ; 
		this.lastName = lastName ;
		this.address = address ;
		this.email = email ;
		this.password = password ;
        this.walletAddress = walletAddress ;

	}

    public void updateRate() {
        if (this.getTotalOperations() == 0) {
            this.rate = 0;
        }else{
            this.rate = (this.getSucessfulOperations() / (this.getTotalOperations() - this.getCancelledOperations())) * 5 ;
        }
    }


    public void updateOperation(){
        this.totalOperations=this.totalOperations + 1;
    }

    public void updateCancelledOperations() {
        this.cancelledOperations = this.cancelledOperations + 1;
    }

    public void updateSuccededOperations() {
        this.sucessfulOperations = this.sucessfulOperations + 1;
    }

    public String getReputation(){
        if (this.getCancelledOperations() == 0 && this.getSucessfulOperations() == 0){
            return "No operation finished yet";
        }else{
            return this.getRate() + " Stars" ;
        }
    }


 @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getUsername() {
        return this.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }


}