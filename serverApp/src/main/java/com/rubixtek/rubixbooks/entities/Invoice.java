package com.rubixtek.rubixbooks.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "invoice")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name="client_id", referencedColumnName = "id")
	private Client client;

	private String invoiceNumber;
	
	private Date invoiceDate;

	private double amount;
	private Date payByDate;

	private long creditDays;

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade = CascadeType.ALL)
	@JsonManagedReference(value="invoice-invoiceItem")
	
	private List<InvoiceItem> invoiceItems;

	public Invoice() {
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}


	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Date getDate() {
		return invoiceDate;
	}

	public void setDate(Date date) {
		this.invoiceDate = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getPayByDate() {
		return payByDate;
	}

	public void setPayByDate(Date payByDate) {
		this.payByDate = payByDate;
	}

	public long getCreditDays() {
		return creditDays;
	}

	public void setCreditDays(long creditDays) {
		this.creditDays = creditDays;
	}

	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}

	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}


	@Override
	public int hashCode() {
		return Objects.hash(client, invoiceDate, invoiceNumber);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return Objects.equals(client, other.client) && Objects.equals(invoiceDate, other.invoiceDate)
				&& Objects.equals(invoiceNumber, other.invoiceNumber);
	}
	
	

}
