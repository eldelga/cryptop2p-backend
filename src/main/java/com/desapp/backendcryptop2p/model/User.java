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



	public User(UserBuilder userBuilder) {
		this.firstName = userBuilder.firstName; ;
		this.lastName = userBuilder.lastName ;
		this.address = userBuilder.address ;
		this.email = userBuilder.email ;
		this.password = userBuilder.password ;
        this.walletUrl = userBuilder.walletUrl ;
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

 

    public static class UserBuilder {

             
        private final String firstName;
        private final String lastName;
        private String address;
        private String email;
        private String password;
        private String walletUrl;
    
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public UserBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withWalletUrl(String walletUrl) {
            this.walletUrl = walletUrl;
            return this;
        }  
       
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}