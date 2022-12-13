package com.rubixtek.rubixbooks.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rubixtek.rubixbooks.entities.Bill;
import com.rubixtek.rubixbooks.entities.BillItem;
import com.rubixtek.rubixbooks.entities.Supplier;


@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
	BillItem save(BillItem billItem);
	Bill findByBillNoAndSupplier(int bill,Supplier sup);
	//List<Bill> findBySupplierIdAndDate(Bill billObj);
	@Query(value = "from Bill b where billDate BETWEEN :startDate AND :endDate")
	List<Bill> findBillByStartAndEndDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);	 
}
