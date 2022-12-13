package com.rubixtek.rubixbooks.serviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Bill;
import com.rubixtek.rubixbooks.entities.BillItem;
import com.rubixtek.rubixbooks.entities.Supplier;
import com.rubixtek.rubixbooks.exception.ResourceNotFoundException;
import com.rubixtek.rubixbooks.repository.BillItemRepository;
import com.rubixtek.rubixbooks.repository.BillRepository;
import com.rubixtek.rubixbooks.service.BillService;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;
	@Autowired
	private BillItemRepository billItemRepository;

	@Override
	public List<Bill> getAllBills() {

		return billRepository.findAll();
	}

	@Override
	public Bill getBillById(long id) {
		Optional<Bill> optional = billRepository.findById(id);
		if (optional.isPresent()) {

			return optional.get();
		} else {
			throw new RuntimeException(" Bill not found for id: " + id);
		}
	}

	@Override
	public Bill createBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public Bill updateBillById(Bill updateBillID, long id) {
		updateBillID.setId(id);
		return billRepository.save(updateBillID);
	}

	@Override
	public String deleteBill(Long billId) {
		if (billRepository.existsById(billId)) {
			billRepository.deleteById(billId);
			return billId + "deleted successfully";
		} else {
			return "the bill datadoes not exist in records!";
		}
	}

	// Bill Items CRUD

	@Override
	public List<BillItem> getAllBillItems() {

		return billItemRepository.findAll();
	}

	@Override
	public BillItem getBillItemById(long id) {
		Optional<BillItem> optional = billItemRepository.findById(id);
		if (optional.isPresent()) {

			return optional.get();
		} else {
			throw new RuntimeException(" Bill not found for id: " + id);
		}
	}

	@Override
	public BillItem createBillItem(BillItem billItem) {
		return billItemRepository.save(billItem);
	}

	@Override
	public List<BillItem> createBillItems(List<BillItem> billItem) {
		return billItemRepository.saveAll(billItem);
	}

	@Override
	public String deleteBillItem(Long billItemId) {
		if (billItemRepository.existsById(billItemId)) {
			billItemRepository.deleteById(billItemId);
			return billItemId + "deleted successfully";
		} else {
			return "the bill item data does not exist in records!";
		}
	}

	@Override
	public Bill fetchBillByBillNo(int billNO, Supplier sup) {
		Bill billdata = billRepository.findByBillNoAndSupplier(billNO, sup);
		if (billdata != null) {
			return billdata;
		} else {
			throw new ResourceNotFoundException("Bill", "billNo", billNO);
		}
	}

	@Override
	public List<Bill> getBillsWithDate(LocalDate startDate, LocalDate endDate) {
		List<Bill> listOfBill = null;

		if (startDate.isAfter(endDate) && (endDate.isBefore(startDate))) {
//			Bill billObj = new Bill();
//			billObj.setBillDate(Date.valueOf(billStartDate));
//			billObj.setBillDate(Date.valueOf(billEndDate));
////			Supplier sup= new Supplier();
////			sup.setId(supplier.getId());
//			billObj.setSupplier(supplier);
			// listOfBill= billRepository.findBySupplierIdAndDate(billObj);
			listOfBill = billRepository.findBillByStartAndEndDate(startDate, endDate);
		}

		return listOfBill;
	}

}
