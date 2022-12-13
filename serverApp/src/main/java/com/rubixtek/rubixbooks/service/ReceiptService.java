package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.Receipt;

public interface ReceiptService {
	
	public abstract List<Receipt> getAllReceipt();
	public abstract void saveReceipt(Receipt receipt);
	public abstract Receipt getReceiptById(long id);
	public abstract boolean deleteReceipt(long id);
}
