package com.rubixtek.rubixbooks.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rubixtek.rubixbooks.entities.Invoice;
import com.rubixtek.rubixbooks.entities.InvoiceItem;
import com.rubixtek.rubixbooks.repository.InvoiceItemRepository;
import com.rubixtek.rubixbooks.repository.InvoiceRepository;
import com.rubixtek.rubixbooks.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	private InvoiceRepository invoicepository;
	@Autowired
	private InvoiceItemRepository invoiceItemRepository;

	@Override
	public List<Invoice> getAllInvoices() {

		return invoicepository.findAll();
	}

	@Override
	public Invoice getInvoiceById(long id) {
		return invoicepository.findById(id).get();
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		return invoicepository.save(invoice);
	}

	@Override
	public Invoice updateInvoiceById(Invoice updateInvoiceID, long id) {
		updateInvoiceID.setId(id);
		return invoicepository.save(updateInvoiceID);
	}

	@Override
	public String deleteInvoice(Long invoiceId) {
		if (invoicepository.existsById(invoiceId)) {
			invoicepository.deleteById(invoiceId);
			return invoiceId + "deleted successfully";
		} else {
			return "The Invoice datadoes not exist in records!";
		}
	}

	// Invoice Items CRUD

	@Override
	public List<InvoiceItem> getAllInvoiceItems() {

		return invoiceItemRepository.findAll();
	}

	@Override
	public InvoiceItem getInvoiceItemById(long id) {
		Optional<InvoiceItem> optional = invoiceItemRepository.findById(id);
		if (optional.isPresent()) {

			return optional.get();
		} else {
			throw new RuntimeException(" Invoice not found for id: " + id);
		}
	}

	@Override
	public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem) {
		return invoiceItemRepository.save(invoiceItem);
	}

	@Override
	public List<InvoiceItem> createInvoiceItems(List<InvoiceItem> invoiceItem) {
		return invoiceItemRepository.saveAll(invoiceItem);
	}

	@Override
	public String deleteInvoiceItem(Long invoiceItemId) {
		if (invoiceItemRepository.existsById(invoiceItemId)) {
			invoiceItemRepository.deleteById(invoiceItemId);
			return invoiceItemId + "deleted successfully";
		} else {
			return "The invoice item data does not exist in records!";
		}
	}

}
