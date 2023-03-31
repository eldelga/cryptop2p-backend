package com.desapp.backendcryptop2p.model;


public class User {

    private Long id;
    private String name;
    private String lastName;
    private String address;
    private String email;
    private String password; 

	public User(String name ,String lastname ,String address ,String email ,String password ) {
		this.name = name ;
		this.lastName = lastname ;
		this.address = address ;
		this.email = email ;
		this.password = password ;
	}


    public Long getId() {
    	return this.id ;
    }
    
    public String getName() {
    	return this.name ;
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