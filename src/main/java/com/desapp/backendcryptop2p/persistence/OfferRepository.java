package com.desapp.backendcryptop2p.persistence;


import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.Offer;


@Repository
public interface OfferRepository extends JpaRepository<Offer,Integer> {
    @Query("select offer , u  from Offer as offer join offer.createdBy as u where offer.isActive = ?1")
    ArrayList<Offer> findAllByActive(boolean active) ;
}