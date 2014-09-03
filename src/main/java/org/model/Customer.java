package org.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer_tbl")
public class Customer {
	@Id
	private String cid;
	private String cname;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="product_customer" ,joinColumns={@JoinColumn(name="cid")}, inverseJoinColumns={@JoinColumn(name="pid")})
	private Set<Product> plist;

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set<Product> getPlist() {
		return plist;
	}

	public void setPlist(Set<Product> plist) {
		this.plist = plist;
	}

	public Customer(String cid, String cname, Set<Product> plist) {
		this.cid = cid;
		this.cname = cname;
		this.plist = plist;
	}

	public Customer() {

	}

}
