package com.desapp.backendcryptop2p.model;

public class UserFactory {
    public static User anyUser(){
        return new User("Sergio","Delgadillo","Fake 123 st","user@domain.com","Password","AAEEFF11");
    }

    public static User createWith2CharactersName(){
        User user = anyUser() ;
        user.setFirstName("sd");
        return user;
    }

    public static User createWith31CharactersName(){
        User user = anyUser() ;
        user.setFirstName("SergioSergioSergioSergioSergioS");
        return user;
    }

    public static User createWith2CharactersLastName(){
        User user = anyUser() ;
        user.setLastName("De");
        return user;
    }

    public static User createWith31CharactersLastName(){
        User user = anyUser() ;
        user.setLastName("DelgadilloDelgadilloDelgadilloD");
        return user;
    }

    public static User createWithInvalidEmail(){
        User user = anyUser() ;
        user.setEmail("userdomain.com");
        return user;
    }

    public static User createWith9CharacterAddress(){
        User user = anyUser() ;
        user.setAddress("Fake st 1");
        return user;
    }


// Contraseña: al menos 1 minuscula, 1 mayuscula, 1 carac especial y min 6
// CVU MercadoPago, Obligatorio (22 digitos)
// Dirección Billetera de CriptoActivos, Obligatorio (8 dígitos)

}
