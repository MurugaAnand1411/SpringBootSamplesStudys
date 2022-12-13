package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubixtek.rubixbooks.entities.Invoice;
import com.rubixtek.rubixbooks.entities.Receipt;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, Long>{

}
