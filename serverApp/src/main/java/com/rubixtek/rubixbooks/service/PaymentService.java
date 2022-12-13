package com.rubixtek.rubixbooks.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Payment;

public interface PaymentService {
	public List<Payment> listAll();
	public Payment save(Payment payment);
	public List<Payment> saveAll(List<Payment> payment) ;
	public Payment get(long id);
	public void delete(long id);
}
