package org.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_tbl")
public class Person {
	@Id
	private String pid;
	private String pname;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id_fk", unique=true)
	private AddressDetail address;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public AddressDetail getAddress() {
		return address;
	}

	public void setAddress(AddressDetail address) {
		this.address = address;
	}

	public Person(String pid, String pname) {
		this.pid = pid;
		this.pname = pname;
	}

	public Person() {

	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", address="
				+ address + "]";
	}

}
