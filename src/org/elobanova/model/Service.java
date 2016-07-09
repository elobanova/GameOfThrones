package org.elobanova.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Service {
	private static final int PRIM_KEY = 1;
	private final SessionFactory sessionFactory;

	public Service() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public void save(Person person) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	public Person load() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Object retrievedObject = session.get(Person.class, PRIM_KEY);
		if (retrievedObject instanceof Person) {
			return (Person) retrievedObject;
		}

		return null;
	}

	public static void main(String[] args) {
		Person person = new Person();
		person.setFirstName("John Snow");
		new Service().save(person);
	}
}
