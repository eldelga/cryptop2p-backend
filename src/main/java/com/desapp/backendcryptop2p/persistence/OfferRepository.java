package com.desapp.backendcryptop2p.persistence;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.Offer;


@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
    @Query("from Offer offer join offer.createdBy u where offer.isActive = ?1")
    List<Offer> findAllByActive(boolean active) ;
}