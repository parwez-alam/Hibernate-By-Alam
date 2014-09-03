package org.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address_detail")
public class AddressDetail {
	@Id
	private String addressid;
	private String aptno;
	private String street;
	private String city;
	
	public String getAddressid() {
		return addressid;
	}
	public void setAddressid(String addressid) {
		this.addressid = addressid;
	}
	public String getAptno() {
		return aptno;
	}
	public void setAptno(String aptno) {
		this.aptno = aptno;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public AddressDetail(String addressid,String aptno, String street, String city) {
		this.addressid=addressid;
		this.aptno=aptno;
		this.street = street;
		this.city = city;
	}
	public AddressDetail(){
		
	}
	@Override
	public String toString() {
		return "AddressDetail [addressid=" + addressid + ", aptno=" + aptno
				+ ", street=" + street + ", city=" + city + "]";
	}
	

}
