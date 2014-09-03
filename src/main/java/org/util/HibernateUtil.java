package org.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	public static SessionFactory sf;
	static {
		Configuration cfg = new AnnotationConfiguration().configure();
		sf = cfg.buildSessionFactory();
	}

	public static Session openConnction() {
		return sf.openSession();
	}

}
