package org.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.College;
import org.model.University;
import org.util.HibernateUtil;

public class OnetoManyExecutor {
	public static void main(String[] args) {
		// insertOnetoMany();
		// selectAll();
		delete_orphan();
	}

	private static void insertOnetoMany() {

		College college1 = new College("C110-" + new Random().nextInt(999),
				"Engg.", "A+");
		College college2 = new College("C110-" + new Random().nextInt(999),
				"Mgmt", "A");
		College college3 = new College("C110-" + new Random().nextInt(999),
				"Sc", "A++");

		List<College> collegelist = new ArrayList<College>();
		collegelist.add(college1);
		collegelist.add(college2);
		collegelist.add(college3);

		Session session = HibernateUtil.openConnction();
		session.getTransaction().begin();

		University university = new University("U140-"
				+ new Random().nextInt(999), "DU", collegelist);
		session.save(university);
		session.getTransaction().commit();
		session.close();
	}

	private static void selectAll() {
		Session session = HibernateUtil.openConnction();
		Query selectall = session.createQuery("from University");
		List<University> ulist = selectall.list();
		for (University university : ulist) {
			System.out.println(university);
		}
	}

	private static void delete_orphan() {
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();
		University u = (University) session.get(University.class, "U100-69");
		List<College> colList = u.getCollegeList();
		for (int i = 0; i < colList.size(); i++) {
			if (colList.get(i).getCollegeId().equals("C100-661")) {
				colList.remove(i);
			}
		}
		tx.commit();
		session.close();
	}
}
