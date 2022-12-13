package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.Supplier;

public interface SupplierService {
	public Supplier registerSupplier(Supplier supplier);
	public List<Supplier> listOfSuppliers();
	public Supplier getSupplierById(Long id);
	public Supplier updateSupplierById(Long id,Supplier supplier);
	boolean deleteSupplierById(Long id);
	
}
