package com.desapp.backendcryptop2p.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.CryptoActive;
import com.desapp.backendcryptop2p.model.CryptoType;

import java.util.List;

@Repository
public interface CryptoActiveRepository extends JpaRepository<CryptoActive,String> {
    @Query("SELECT cryptoActive FROM CryptoActive cryptoActive WHERE cryptoActive.createAt = (SELECT MAX(cryptoActive2.createAt) FROM CryptoActive cryptoActive2 WHERE cryptoActive2.symbol = cryptoActive.symbol) GROUP BY cryptoActive.symbol")
    List<CryptoActive> getLastUpdated() ;

    @Query("FROM CryptoActive ca WHERE ca.symbol = ?1 AND ca.createAt = (SELECT MAX(ca2.createAt) FROM CryptoActive ca2 WHERE ca2.symbol = ?1)")
    CryptoActive getLastBySymbol(CryptoType symbol) ;
}
