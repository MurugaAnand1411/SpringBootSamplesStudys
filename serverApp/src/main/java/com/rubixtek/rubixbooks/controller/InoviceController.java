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

import com.rubixtek.rubixbooks.entities.Invoice;
import com.rubixtek.rubixbooks.entities.InvoiceItem;
import com.rubixtek.rubixbooks.service.InvoiceService;

@RestController
@RequestMapping("invoice")
public class InoviceController {
	@Autowired
	private InvoiceService invoiceService;

	// Invoice

	@GetMapping("/getInvoiceById/{id}")
	public ResponseEntity<Invoice> fetchOneInvoice(@PathVariable Long id) {
		Invoice getOneInvoice = invoiceService.getInvoiceById(id);
		return ResponseEntity.ok().body(getOneInvoice);
	}

	@GetMapping("/getAllInvoices")
	public ResponseEntity<List<Invoice>> fetchAllInvoices() {
		List<Invoice> invoiceList = invoiceService.getAllInvoices();
		return ResponseEntity.ok().body(invoiceList);
	}

	@PostMapping("/creteInvoice")
	public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice) {
		invoiceService.createInvoice(invoice);
		URI uri = URI.create("/storeAllInvoice");
		return ResponseEntity.created(uri).body(invoice);
	}

	@PutMapping("/updateInvoice/{id}")
	ResponseEntity<Invoice> updateInvoice(@RequestBody Invoice invoice, @PathVariable Long id) {
		Invoice updateInvoiceList = invoiceService.getInvoiceById(id);
		updateInvoiceList.setId(id);
		updateInvoiceList.setAmount(invoice.getAmount());
		updateInvoiceList.setDate(invoice.getDate());
		updateInvoiceList.setInvoiceNumber(invoice.getInvoiceNumber());
		updateInvoiceList.setCreditDays(invoice.getCreditDays());
		updateInvoiceList.setPayByDate(invoice.getPayByDate());
		invoiceService.createInvoice(updateInvoiceList);
		URI uri = URI.create("updateInvoiceList");
		return ResponseEntity.created(uri).body(updateInvoiceList);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteInvoieById(@PathVariable("id") Long id) {

		String deleteInvoice = invoiceService.deleteInvoice(id);
		URI uri = URI.create("delete");
		return ResponseEntity.created(uri).body(deleteInvoice);
	}

//InvoiceItem

	@GetMapping("/getInvoiceItemById/{id}")
	public ResponseEntity<InvoiceItem> fetchOneInvoiceItems(@PathVariable Long id) {
		InvoiceItem getOneInvoiceItem = invoiceService.getInvoiceItemById(id);
		return ResponseEntity.ok().body(getOneInvoiceItem);
	}

	@GetMapping("/getAllInvoiceItems")
	public ResponseEntity<List<InvoiceItem>> fetchAllInoviceItems() {
		List<InvoiceItem> invoiceItemList = invoiceService.getAllInvoiceItems();
		return ResponseEntity.ok().body(invoiceItemList);
	}

	@PostMapping("/crateInvoiceItem")
	public ResponseEntity<InvoiceItem> saveInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
		invoiceService.createInvoiceItem(invoiceItem);
		URI uri = URI.create("/saveInvoiceItem");
		return ResponseEntity.created(uri).body(invoiceItem);
	}

	@PostMapping("/createInvoiceItems")
	public ResponseEntity<List<InvoiceItem>> saveAllInvoiceItemss(@RequestBody List<InvoiceItem> invoiceItemsSave) {
		invoiceService.createInvoiceItems(invoiceItemsSave);
		URI uri = URI.create("/storeAll");
		return ResponseEntity.created(uri).body(invoiceItemsSave);
	}

	@PutMapping("/updateInvoiceItem/{id}")
	ResponseEntity<InvoiceItem> updateInvoiceItem(@RequestBody InvoiceItem invoiceItem, @PathVariable Long id) {
		InvoiceItem updateInvoiceItem = invoiceService.getInvoiceItemById(id);
		updateInvoiceItem.setId(id);
		updateInvoiceItem.setDescription(invoiceItem.getDescription());
		updateInvoiceItem.setItem(invoiceItem.getItem());
		updateInvoiceItem.setQuantity(invoiceItem.getQuantity());
		updateInvoiceItem.setSerialNo(invoiceItem.getSerialNo());
		updateInvoiceItem.setUnitPrice(invoiceItem.getUnitPrice());
		updateInvoiceItem.setLineTotal(invoiceItem.getLineTotal());
		invoiceService.createInvoiceItem(updateInvoiceItem);
		URI uri = URI.create("updateInvoiceItem");
		return ResponseEntity.created(uri).body(updateInvoiceItem);
	}

	@DeleteMapping("deleteInvoiceItem/{id}")
	public ResponseEntity<String> deleteInvoiceItemById(@PathVariable("id") Long id) {
		String deleteInvoiceItem = invoiceService.deleteInvoiceItem(id);
		URI uri = URI.create("delete");
		return ResponseEntity.created(uri).body(deleteInvoiceItem);
	}

}
