package org.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "v")
public class Vendor extends User {
	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Vendor(String uid, String fname, String lname, String address) {
		super(uid, fname, lname);
		this.address = address;
	}

	public Vendor() {

	}

}
