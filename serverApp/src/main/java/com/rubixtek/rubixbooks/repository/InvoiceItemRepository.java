package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubixtek.rubixbooks.entities.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long>{

}
