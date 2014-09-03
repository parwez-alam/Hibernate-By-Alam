package org.dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Employee;
import org.util.HibernateUtil;

public class EmployeeExecutor {
	public static void main(String[] args) {
		insertEmployee();
		// selectAllEmployee();
		// selectEmployeebyId();
		// updateEmployeebyId();
		// deleteEmployeebyId();
		// selectSomeProperty();
	}

	/*
	 * String type of database..... EMP-290 EMP-291 EMP-292
	 */
	private static void insertEmployee() {
		Employee employee = new Employee("Mr.", "Tridib",
				"ashish@googlemail.com", "7787878", "Training", new Date(),
				6000D);
		/*
		 * Configuration cfg = new Configuration().configure(); SessionFactory
		 * sf = cfg.buildSessionFactory();
		 */
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();
		try {
			session.save(employee);
			tx.commit();
			System.out
					.println("one object is inserted into database.......!!!");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	private static void selectAllEmployee() {
		Session session = HibernateUtil.openConnction();
		// SQL: select * from employee_tbl;

		// HQL: hibernate query language.
		// tablename= entityname/classname
		// column-name=property of entity/class

		Query showAllEmp = session.createQuery("from Employee");
		List<Employee> emplist = showAllEmp.list();
		for (Employee emp : emplist) {
			System.out.println(emp);
		}
		session.close();
	}

	private static void selectEmployeebyId() {
		Session session = HibernateUtil.openConnction();
		// select some property and display
		Query showAllEmp = session.createQuery("from Employee where eid=2");
		System.out.println(showAllEmp.list());
		session.close();
	}

	private static void updateEmployeebyId() {
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();

		Query showAllEmp = session
				.createQuery("update Employee set email='abc@google.com' where eid=2");
		System.out.println(showAllEmp.executeUpdate()
				+ " Row has beed updated....!");
		tx.commit();
		session.close();
	}

	private static void deleteEmployeebyId() {
		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();

		Query showAllEmp = session.createQuery("delete Employee where eid=3");
		System.out.println(showAllEmp.executeUpdate()
				+ " Row has beed deleted....!");
		tx.commit();
		session.close();
	}

	private static void selectSomeProperty() {
		Session session = HibernateUtil.openConnction();
		Query selectField = session
				.createQuery("select e.eid,e.fname,e.lname, e.salary from Employee e");
		List list = selectField.list();
		Iterator it = list.iterator();
		if (!it.hasNext()) {
			System.out.println("Data does not exist");
		} else {
			System.out
					.println("--------------------------------------------------");
			System.out.println("ID" + "\t" + "FName" + "\t" + "LName" + "\t"
					+ "Salary");
			while (it.hasNext()) {
				Object[] row = (Object[]) it.next();
				for (int i = 0; i < row.length; i++) {
					System.out.print(row[i] + "\t");

				}
				System.out.println();
			}
		}
	}
}
