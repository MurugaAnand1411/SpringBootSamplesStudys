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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.Supplier;
import com.rubixtek.rubixbooks.service.SupplierService;

@RestController
@RequestMapping("supplier")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;

	@GetMapping("/viewAll")
	public ResponseEntity<List<Supplier>> listOfSuppliers() {
		List<Supplier> supplierlist=supplierService.listOfSuppliers();
		return ResponseEntity.ok().body(supplierlist);
	}

	@PostMapping("/create")
	public ResponseEntity<Supplier> saveSupplier(@RequestBody Supplier supplier) {
		supplierService.registerSupplier(supplier);
		URI uri = URI.create("/view/" + supplier.getId());
		return ResponseEntity.created(uri).body(supplier);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Supplier> updateSupplier( @PathVariable("id") Long id,@RequestBody Supplier supplier){
		supplierService.updateSupplierById(id,supplier);
		URI uri = URI.create("/updateSupplier/"+ supplier.getId());
		return ResponseEntity.created(uri).body(supplier);
	}

	@GetMapping("/view/{id}")
	public ResponseEntity<Supplier> getSupplierById(@PathVariable long id) {
		Supplier supplier=supplierService.getSupplierById(id);
		return ResponseEntity.ok().body(supplier);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteSupplierById(@PathVariable long id) {
		if (!supplierService.deleteSupplierById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().build();
		}
	}

}
