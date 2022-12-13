package com.rubixtek.rubixbooks.entities;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "invoiceItem")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "invoice_id")
	@JsonBackReference(value = "invoice-invoiceItem")
	private Invoice invoice;

	private int serialNo;
	private String item;
	private String description;
	private double unitPrice;
	private double quantity;
	private double lineTotal;
	public InvoiceItem() {
	}

	public InvoiceItem(Invoice invoice, String item, String description, double unitPrice, double quantity, double lineTotal) {
		this.invoice = invoice;
		this.item = item;
		this.description = description;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.lineTotal = lineTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getLineTotal() {
		return lineTotal;
	}

	public void setLineTotal(double lineTotal) {
		this.lineTotal = lineTotal;
	}

	@Override
	public String toString() {
		return "InvoiceItem [id=" + id + ", invoice=" + invoice + ", item=" + item + ", description=" + description
				+ ", unitPrice=" + unitPrice + ", quantity=" + quantity + lineTotal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoice, serialNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceItem other = (InvoiceItem) obj;
		return Objects.equals(invoice, other.invoice) && serialNo == other.serialNo;
	}

	
}
