package com.rubixtek.rubixbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubixtek.rubixbooks.entities.BillItem;

public interface BillItemRepository extends JpaRepository<BillItem, Long> {

}
