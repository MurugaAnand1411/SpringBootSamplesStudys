package com.rubixtek.rubixbooks.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rubixtek.rubixbooks.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{


}
