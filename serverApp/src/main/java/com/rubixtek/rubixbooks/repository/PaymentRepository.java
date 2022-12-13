package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubixtek.rubixbooks.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
