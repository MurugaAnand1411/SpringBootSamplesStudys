package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Customer;
import com.rubixtek.rubixbooks.repository.CustomerRepository;
import com.rubixtek.rubixbooks.service.CustomerService;



@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer)
	{
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer()
	{	
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerbyId(Long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public String updateCustomer(Customer customer, long id) {
		customer.setId(id);
		customerRepository.save(customer);
		return "Successfully Updated";
		
	}

	@Override
	public void deleteCustomerById(Long id) {
		 customerRepository.deleteById(id);
	}

	

}
