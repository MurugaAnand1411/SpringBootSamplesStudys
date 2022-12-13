package com.rubixtek.rubixbooks.service;

import java.time.LocalDate;
import java.util.List;

import com.rubixtek.rubixbooks.entities.Bill;
import com.rubixtek.rubixbooks.entities.BillItem;
import com.rubixtek.rubixbooks.entities.Supplier;

public interface BillService {
//Bill
	public Bill getBillById(long id);

	public List<Bill> getAllBills();

	public Bill createBill(Bill bill);

	public Bill updateBillById(Bill updateBillID, long id);

	public String deleteBill(Long billId);

//BillItem	
	public BillItem getBillItemById(long id);

	public List<BillItem> getAllBillItems();

	public BillItem createBillItem(BillItem billItem);

	public List<BillItem> createBillItems(List<BillItem> billItem);

	public String deleteBillItem(Long billItemId);

	public Bill fetchBillByBillNo(int billNO, Supplier sup);

	public List<Bill> getBillsWithDate(LocalDate billStartDate, LocalDate billEndDate);

}
