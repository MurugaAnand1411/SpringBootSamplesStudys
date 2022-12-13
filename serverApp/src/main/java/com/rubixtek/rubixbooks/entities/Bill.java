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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "bill")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	private int billNo;
	private Date billDate;
	private double amount;
	private Date payByDate;
	private long creditDays;
	
	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "supplier_id", referencedColumnName = "id")
	private Supplier supplier;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bill", cascade = CascadeType.MERGE)
	@JsonManagedReference(value="bill-billItem")
	private List<BillItem> billItems;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
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

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Bill() {
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(billDate, billNo, supplier);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return Objects.equals(billDate, other.billDate) && billNo == other.billNo
				&& Objects.equals(supplier, other.supplier);
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", billNo=" + billNo + ", billDate=" + billDate + ", amount=" + amount
				+ ", payByDate=" + payByDate + ", creditDays=" + creditDays + ", billItems=" + billItems + ", supplier="
				+ supplier + "]";
	}

}
