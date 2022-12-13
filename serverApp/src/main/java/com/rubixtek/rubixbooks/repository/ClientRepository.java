package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubixtek.rubixbooks.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{


}
