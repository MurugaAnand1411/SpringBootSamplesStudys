package com.rubixtek.rubixbooks.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rubixtek.rubixbooks.entities.Bill;
import com.rubixtek.rubixbooks.entities.BillItem;
import com.rubixtek.rubixbooks.service.BillService;

@RestController
@RequestMapping("bill")
public class BillController {
	@Autowired
	private BillService billService;

	// Bill

	@GetMapping("/getBillById/{id}")
	public ResponseEntity<Bill> fetchOneBill(@PathVariable Long id) {
		Bill getOneBill = billService.getBillById(id);
		return ResponseEntity.ok().body(getOneBill);
	}

	@GetMapping("/getAllBills")
	public ResponseEntity<List<Bill>> fetchAllBills() {
		List<Bill> billList = billService.getAllBills();
		return ResponseEntity.ok().body(billList);
	}

	@PostMapping("/creteBill")
	public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
		billService.createBill(bill);
		URI uri = URI.create("/storeAllBill");
		return ResponseEntity.created(uri).body(bill);
	}

	@PutMapping("/updateBill/{id}")
	ResponseEntity<Bill> updateBill(@RequestBody Bill bill, @PathVariable Long id) {
		Bill updateBillList = billService.getBillById(id);
		updateBillList.setId(id);
		updateBillList.setAmount(bill.getAmount());
		updateBillList.setBillDate(bill.getBillDate());
		// updateBillList.setBillItems(bill.getBillItems());
		updateBillList.setBillNo(bill.getBillNo());
		updateBillList.setCreditDays(bill.getCreditDays());
//		updateBillList.setSupplier(bill.getSupplier());
		updateBillList.setPayByDate(bill.getPayByDate());
		billService.createBill(updateBillList);
		URI uri = URI.create("updateBillList");
		return ResponseEntity.created(uri).body(updateBillList);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteBillById(@PathVariable("id") Long id) {

		String deleteBill = billService.deleteBill(id);
		URI uri = URI.create("delete");
		return ResponseEntity.created(uri).body(deleteBill);
	}

//BillItem

	@GetMapping("/getBillItemById/{id}")
	public ResponseEntity<BillItem> fetchOneBillItems(@PathVariable Long id) {
		BillItem getOneBillItem = billService.getBillItemById(id);
		return ResponseEntity.ok().body(getOneBillItem);
	}

	@GetMapping("/getAllBillItems")
	public ResponseEntity<List<BillItem>> fetchAllBillItems() {
		List<BillItem> billItemList = billService.getAllBillItems();
		return ResponseEntity.ok().body(billItemList);
	}

	@PostMapping("/crateBillItem")
	public ResponseEntity<BillItem> saveBillItem(@RequestBody BillItem billItemSave) {
		billService.createBillItem(billItemSave);
		URI uri = URI.create("/saveBillItem");
		return ResponseEntity.created(uri).body(billItemSave);
	}

	@PostMapping("/createBillItems")
	public ResponseEntity<List<BillItem>> saveAllBillItemss(@RequestBody List<BillItem> billItemsSave) {
		// billService.createBillItem(Bill bill, billItemSave);
		billService.createBillItems(billItemsSave);
		URI uri = URI.create("/storeAll");
		return ResponseEntity.created(uri).body(billItemsSave);
	}

	@PutMapping("/updateBillItem/{id}")
	ResponseEntity<BillItem> updateBillItem(@RequestBody BillItem billItem, @PathVariable Long id) {
		BillItem updateBillItem = billService.getBillItemById(id);
		updateBillItem.setId(id);
//		updateBillItem.setBill(billItem.getBill());
		updateBillItem.setDescription(billItem.getDescription());
		updateBillItem.setItem(billItem.getItem());
		updateBillItem.setLineTotal(billItem.getLineTotal());
		updateBillItem.setQuantity(billItem.getQuantity());
		updateBillItem.setSerialNo(billItem.getSerialNo());
		updateBillItem.setUnitPrice(billItem.getUnitPrice());
		billService.createBillItem(updateBillItem);
		URI uri = URI.create("updateBillItem");
		return ResponseEntity.created(uri).body(updateBillItem);
	}

	@DeleteMapping("deleteBillItem/{id}")
	public ResponseEntity<String> deleteBillItemById(@PathVariable("id") Long id) {
		String deleteBillItem = billService.deleteBillItem(id);
		URI uri = URI.create("delete");
		return ResponseEntity.created(uri).body(deleteBillItem);
	}

//	@GetMapping("getBillByBetweenDates")
//	public ResponseEntity<List<Bill>> getBillByBetweenDates(@RequestParam String startDate, String endDate){
//		 LocalDate dateBefore = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
//	        LocalDate dateAfter = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-mm-dd"));
//		List<Bill> bills =  billService.getBillsWithDate(dateBefore, dateAfter);;
//		return ResponseEntity.ok().body(bills);
//		
//	}
}
