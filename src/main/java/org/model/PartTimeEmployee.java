package org.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "part_time_employee")
public class PartTimeEmployee {
	
	
	@Id
	@Column(name = "EmployeeID")
	private String eid;
	private String fname;
	private String lname;
	private String email;
	private String contact;
	@Column(nullable = true, length = 20)
	private String dept;
	private Date jdate;
	private double salary;

		
	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getJdate() {
		return jdate;
	}

	public void setJdate(Date jdate) {
		this.jdate = jdate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public PartTimeEmployee(String fname, String lname,
			String email, String contact, String dept, Date jdate, double salary) {
		
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.dept = dept;
		this.jdate = jdate;
		this.salary = salary;
	}

	public PartTimeEmployee() {

	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname
				+ ", email=" + email + ", contact=" + contact + ", dept="
				+ dept + ", jdate=" + jdate + ", salary=" + salary + "]";
	}

	
}
