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

import com.rubixtek.rubixbooks.entities.Customer;
import com.rubixtek.rubixbooks.service.CustomerService;



@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/CreateCustomer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
        URI uri = URI.create("/" + customer.getId());
        return ResponseEntity.created(uri).body(customer);
    }


	@GetMapping("/GetAllCustomers")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> c = customerService.getAllCustomer();
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }

	@GetMapping("/GetCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		Customer c = customerService.getCustomerbyId(id);
        if (c == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(c);
    }
	
	@PutMapping("/UpdateCustomer/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable long id) {
		Customer updCustomer = customerService.getCustomerbyId(id);
		updCustomer.setId(id);
		updCustomer.setAddress1(customer.getAddress1());
		updCustomer.setAddress2(customer.getAddress2());
		updCustomer.setCity(customer.getCity());
		updCustomer.setCountry(customer.getCountry());
		updCustomer.setName(customer.getName());
		updCustomer.setState(customer.getState());
		updCustomer.setTaxIdentifier(customer.getTaxIdentifier());
		updCustomer.setActive(customer.isActive());
		customerService.updateCustomer(updCustomer, id);
        URI uri = URI.create("/" + customer.getId());
        return ResponseEntity.created(uri).body(updCustomer);
    }
	
	 @DeleteMapping("/DeleteCustomer/{id}")
	    public String deleteCustomer(@PathVariable long id) {
		 customerService.deleteCustomerById(id);
	        return "Deleted successfully : " + id;
	    }
}
