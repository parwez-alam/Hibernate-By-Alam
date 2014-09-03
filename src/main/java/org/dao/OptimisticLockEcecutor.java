package org.dao;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Account;
import org.util.HibernateUtil;

public class OptimisticLockEcecutor {
	public static void main(String[] args) {
		//createAccount();
		updateAccount("SBI-0985");
	}

	private static void createAccount() {
		Account account = new Account("SBI-0985", "Jeff",
				"jeff@synergisticit.com", 3000);
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();
		try {
			session.save(account);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	private static void updateAccount(String acno) {
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();
		/*Query query=session.createQuery("");
		query.setLockMode("mylock", LockMode.UPGRADE);*/
		Account account = (Account) session.get(Account.class, acno);
		session.lock(account, LockMode.UPGRADE);
		if (account != null) {
			try {
				account.setBalance(5000);
				account.setEmail("nagen@synergistic.com");
				session.update(account);
				tx.commit();
			} catch (Exception e) {
				tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
		}
	}

}
