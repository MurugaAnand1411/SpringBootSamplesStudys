package com.rubixtek.rubixbooks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.Receipt;
import com.rubixtek.rubixbooks.serviceImpl.ReceiptServiceImpl;

@RestController
@CrossOrigin
public class ReceiptController {

	@Autowired
	private ReceiptServiceImpl receiptservice;

	@GetMapping("/viewAll")
	public ResponseEntity<List<Receipt>> viewAll() {
		List<Receipt> receiptlist=receiptservice.getAllReceipt();
		return ResponseEntity.ok().body(receiptlist);
	}

	@PostMapping("/create")
	public ResponseEntity<Receipt> createReceipt(@RequestBody Receipt receipt) {
			receiptservice.saveReceipt(receipt);
			URI uri = URI.create("receipt");
			return ResponseEntity.created(uri).body(receipt);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Receipt> updateReceipt(@RequestBody Receipt receipt, @PathVariable Long id){
		Receipt updateList=receiptservice.getReceiptById(id);
		updateList.setDate(receipt.getDate());
		updateList.setAmount(receipt.getAmount());
		receiptservice.saveReceipt(updateList);
		URI uri = URI.create("updateList");
		return ResponseEntity.created(uri).body(updateList);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Receipt> getReceiptById(@PathVariable long id, Receipt receipt) {
		receipt = receiptservice.getReceiptById(id);
		return ResponseEntity.ok().body(receipt);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteReceipt(@PathVariable long id) {
		if (!receiptservice.deleteReceipt(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().build();
		}
	}

}
