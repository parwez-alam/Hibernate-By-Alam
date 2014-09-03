package org.dao;

import java.util.Date;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.PartTimeEmployee;
import org.util.HibernateUtil;

public class PartTimeEmpExecutor {
	public static void main(String[] args) {

		PartTimeEmployee emp = new PartTimeEmployee("Mr", "Nagendra",
				"nagen@synergisticit.com", "99999", "Training", new Date(),
				5000D);

		emp.setEid("EMP-" + new Random().nextInt(99999) + 1);

		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();

		session.save(emp);
		tx.commit();
		session.close();
		System.out.println("one object is inserted into database.......!!!");
	}

}
