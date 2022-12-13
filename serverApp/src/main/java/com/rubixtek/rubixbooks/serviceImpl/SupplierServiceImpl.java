package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Supplier;
import com.rubixtek.rubixbooks.exception.ResourceNotFoundException;
import com.rubixtek.rubixbooks.repository.SupplierRepository;
import com.rubixtek.rubixbooks.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public Supplier registerSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public List<Supplier> listOfSuppliers() {
		return supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplierById(Long id) {
		return supplierRepository.findById(id).get();
	}

	@Override
	public Supplier updateSupplierById(Long id, Supplier supplier) {
		Supplier existingSupplier=supplierRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Supplier","id", id));
		supplier.setId(id);
		existingSupplier.setName(supplier.getName());
		existingSupplier.setAddress1(supplier.getAddress1());
		existingSupplier.setAddress2(supplier.getAddress2());
		existingSupplier.setCity(supplier.getCity());
		existingSupplier.setDistrict(supplier.getDistrict());
		existingSupplier.setState(supplier.getState());
		existingSupplier.setCountry(supplier.getCountry());
		existingSupplier.setZipcode(supplier.getZipcode());
		existingSupplier.setEmail(supplier.getEmail());
		existingSupplier.setPhone(supplier.getPhone());
		existingSupplier.setTaxIdentifier(supplier.getTaxIdentifier());
		return supplierRepository.save(existingSupplier);
		}

	@Override
	public boolean deleteSupplierById(Long id) {
		supplierRepository.deleteById(id);
		return true;
	}

}
