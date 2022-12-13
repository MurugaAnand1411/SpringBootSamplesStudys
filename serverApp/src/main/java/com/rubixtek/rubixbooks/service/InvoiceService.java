package com.rubixtek.rubixbooks.service;

import java.util.List;

import com.rubixtek.rubixbooks.entities.Invoice;
import com.rubixtek.rubixbooks.entities.InvoiceItem;

public interface InvoiceService {
//Invoice
	public Invoice getInvoiceById(long id);

	public List<Invoice> getAllInvoices();

	public Invoice createInvoice(Invoice invoice);

	public Invoice updateInvoiceById(Invoice updateInvoiceID, long id);

	public String deleteInvoice(Long invoiceId);

//InvoiceItem	
	public InvoiceItem getInvoiceItemById(long id);

	public List<InvoiceItem> getAllInvoiceItems();

	public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem);

	public List<InvoiceItem> createInvoiceItems(List<InvoiceItem> invoiceItem);

	public String deleteInvoiceItem(Long invoiceItemId);

}
