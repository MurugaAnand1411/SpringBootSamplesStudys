package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rubixtek.rubixbooks.entities.Payment;
import com.rubixtek.rubixbooks.repository.PaymentRepository;
import com.rubixtek.rubixbooks.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository repo;

	@Override
	public List<Payment> listAll() {
		return repo.findAll();
	}

	@Override
	public Payment save(Payment payment) {
		return repo.save(payment);
	}

	
	@Override
	public Payment get(long id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Payment> saveAll(List<Payment> payment) {
		return repo.saveAll(payment);
	}

}
