package org.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "c")
public class Consumer extends User {
	private Date dob;
	private String limitt;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getLimitt() {
		return limitt;
	}

	public void setLimitt(String limitt) {
		this.limitt = limitt;
	}

	public Consumer(String uid, String fname, String lname, Date dob,
			String limitt) {
		super(uid, fname, lname);
		this.dob = dob;
		this.limitt = limitt;
	}

	public Consumer() {

	}

}
