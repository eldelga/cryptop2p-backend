package com.desapp.backendcryptop2p.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desapp.backendcryptop2p.model.Operation;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Integer> {
}