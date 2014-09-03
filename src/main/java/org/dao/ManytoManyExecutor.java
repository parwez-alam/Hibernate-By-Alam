package org.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Customer;
import org.model.Product;
import org.util.HibernateUtil;

public class ManytoManyExecutor {
	public static void main(String[] args) {
		Product p1 = new Product("p-102", "Pen", 3, 10F);
		Product p2 = new Product("p-203", "Laptop", 2, 1099F);
		Product p3 = new Product("p-105", "Pen drive", 3, 100F);
		
		Product p4 = new Product("p-155", "Flash drive", 1, 300F);

		Set<Product> prodList = new HashSet<Product>();
		Set<Product> prodList1 = new HashSet<Product>();
		prodList.add(p1);
		prodList.add(p2);
		prodList.add(p3);
		prodList1.add(p1);
		prodList1.add(p4);

		Customer c1 = new Customer("C-499", "Parwez", prodList);
		Customer c2 = new Customer("C-469", "Swapnil", prodList1);

		Session session = HibernateUtil.openConnction();
		Transaction tx = session.beginTransaction();

		session.save(c1);
		session.save(c2);
		tx.commit();
		session.close();

	}

}
