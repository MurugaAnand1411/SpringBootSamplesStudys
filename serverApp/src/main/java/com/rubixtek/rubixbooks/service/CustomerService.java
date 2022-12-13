package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.Customer;



public interface CustomerService {
	
    public Customer saveCustomer (Customer customer);
 	
	public List<Customer> getAllCustomer();
	
	public Customer getCustomerbyId(Long id);
	
	public String updateCustomer(Customer customer,long id);
	
	public void deleteCustomerById(Long id);

}
