package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubixtek.rubixbooks.entities.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{

}
