package com.rubixtek.rubixbooks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.Payment;
import com.rubixtek.rubixbooks.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/viewAll")
	public ResponseEntity<List<Payment>> getAllPayment() {
		List<Payment> p = paymentService.listAll();
		if (p == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(p);
	}

	@PostMapping("/create")
	public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
		paymentService.save(payment);
		URI uri = URI.create("/" + payment.getId());
		return ResponseEntity.created(uri).body(payment);
	}

	@PostMapping("/creates")
	public  ResponseEntity<List<Payment>> createPayments(@RequestBody List<Payment> payment) {
		paymentService.saveAll(payment);
		URI uri = URI.create("/viewAll");
		return ResponseEntity.created(uri).body(payment);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment, @PathVariable long id) {
		Payment paymentList = paymentService.get(id);
		payment.setId(id);
		paymentList.setAmount(payment.getAmount());
		paymentList.setDate(payment.getDate());
		paymentService.save(paymentList);
		URI uri = URI.create("/" + payment.getId());
		return ResponseEntity.created(uri).body(payment);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable long id) {
		Payment p = paymentService.get(id);
		if (p == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(p);
	}

	@DeleteMapping("/delete/{id}")
	public void deletePaymentByid(@PathVariable long id) {
		paymentService.delete(id);
	}
}
