package org.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "account_tbl")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries({
		@NamedQuery(name = "find.all.acccount", query = "form Account"),
		@NamedQuery(name = "find.all.email", query = "from Account where email=:myemail"),
		@NamedQuery(name="", query="")})
public class Account {
	@Id
	private String accountno;
	private String name;
	private String email;
	private float balance;

	@Version
	private int opLockValue;// initially it has... zero.
							// once object will be successfully updated, its
							// value will be incremented by 1.

	public String getAccountno() {
		return accountno;
	}

	public void setAccountno(String accountno) {
		this.accountno = accountno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getOpLockValue() {
		return opLockValue;
	}

	public void setOpLockValue(int opLockValue) {
		this.opLockValue = opLockValue;
	}

	public Account(String accountno, String name, String email, float balance) {
		super();
		this.accountno = accountno;
		this.name = name;
		this.email = email;
		this.balance = balance;
	}

	public Account() {

	}
}
