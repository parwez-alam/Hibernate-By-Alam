package org.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Consumer;
import org.model.User;
import org.model.Vendor;
import org.util.HibernateUtil;

public class SingleTablePerClassDemo {
	public static void main(String[] args) {
		User user = new User("u30", "mr", "Ben");
		Consumer consumer = new Consumer("u300", "a", "b", new Date(), "ok");
		Vendor vendor = new Vendor("vv45", "dd", "fff", "nj");

		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();
		try {
			session.save(user);
			session.save(consumer);
			session.save(vendor);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}

		session.close();

	}

}
