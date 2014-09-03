package org.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_tbl")
public class Product {
	@Id
	private String pid;
	private String pnmae;
	private int qty;
	private float price;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "plist")
	private Set<Customer> clist;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPnmae() {
		return pnmae;
	}

	public void setPnmae(String pnmae) {
		this.pnmae = pnmae;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(String pid, String pnmae, int qty, float price) {
		this.pid = pid;
		this.pnmae = pnmae;
		this.qty = qty;
		this.price = price;
	}

	public Product() {

	}

	public Set<Customer> getClist() {
		return clist;
	}

	public void setClist(Set<Customer> clist) {
		this.clist = clist;
	}

}
