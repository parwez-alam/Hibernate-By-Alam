package org.dao;

import java.util.List;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.model.AddressDetail;
import org.model.Person;
import org.util.HibernateUtil;

public class OnetoOneExecutor {
	public static void main(String[] args) {
		insertOnetoOne();
		//selectAll();
	}

	private static void insertOnetoOne() {
		Person person = new Person("P100-" + new Random().nextInt(999),
				"Parwez");
		AddressDetail address = new AddressDetail("A410-"
				+ new Random().nextInt(999), "G-54", "M G Road", "Noida");
		person.setAddress(address);

		Session session = HibernateUtil.openConnction();
		session.getTransaction().begin();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	private static void selectAll() {
		Session session = HibernateUtil.openConnction();
		Criteria criteria = session.createCriteria(Person.class);
		List<Person> plist = criteria.list();
		for (Person p : plist) {
			System.out.println(p);
		}
		session.close();

	}
}
