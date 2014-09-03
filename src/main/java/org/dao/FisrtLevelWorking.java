package org.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.model.Account;
import org.util.HibernateUtil;

public class FisrtLevelWorking {
	public static void main(String[] args) {
		firstAndSecondLevelCache();
	}

	private static void firstAndSecondLevelCache() {
		Session s1 = HibernateUtil.openConnction();
		Account account1 = (Account) s1.get(Account.class, "SBI-0985");
		System.out.println(account1);

		Account account2 = (Account) s1.get(Account.class, "SBI-0985");
		System.out.println(account2);
		s1.close();

		Session s2 = HibernateUtil.openConnction();
		Account account3 = (Account) s2.get(Account.class, "SBI-0985");
		System.out.println(account3);
		s2.close();
	}

	private static void queryLevelCache() {
		Session s1 = HibernateUtil.openConnction();
		
		Query query = s1.createQuery("from Account where balance>=4000F");
		query.setCacheable(true);
		System.out.println(query.list());

		Session s2 = HibernateUtil.openConnction();
		Query query1 = s2.createQuery("from Account where balance>=4000F");
		query1.setCacheable(true);
		System.out.println(query1.list());
	}
	
	private static void callNamedQuery(){
		Session s1 = HibernateUtil.openConnction();
		Query query=s1.getNamedQuery("find.all.email");
		query.setParameter("myemail", "a@gmail.com");
		
		
	}
}
