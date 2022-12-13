package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Receipt;
import com.rubixtek.rubixbooks.repository.ReceiptRepository;
import com.rubixtek.rubixbooks.service.ReceiptService;

@Service
@Transactional
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	private ReceiptRepository receiptRepo;
	
	@Override
	public List<Receipt> getAllReceipt(){
		return receiptRepo.findAll();
	}
	
	@Override
	public void saveReceipt(Receipt receipt) {
		this.receiptRepo.save(receipt);
	}

	@Override
	public Receipt getReceiptById(long id) {
		Optional<Receipt> optional=receiptRepo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
            throw new RuntimeException(" Receipt not found for id :: " + id);
        }
	}

	@Override
	public boolean deleteReceipt(long id) {
		this.receiptRepo.deleteById(id);
		return true;
	}
	
	
}
