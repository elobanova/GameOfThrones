package org.elobanova.model;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

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
		Person johnSnow = new Person();
		johnSnow.setFirstName("John Snow Bastard");
		Calendar cal = Calendar.getInstance();
		cal.set(1001, 01, 10);
		johnSnow.setBornDate(cal.getTime());
		Sword sword = new Sword();
		sword.setForgedAt(johnSnow.getBornDate());
		sword.setLength(100500.42);
		johnSnow.setSword(sword);

		Pet direWolf = new Pet();
		direWolf.setNickName("John Snow's Dire Wolf Puff");
		direWolf.setAlive(false);

		Pet flyingDove = new Pet();
		flyingDove.setNickName("John Snow's Flying Dove A319");
		flyingDove.setAlive(true);

		Set<Pet> johnSnowPets = new HashSet<>();
		johnSnowPets.add(direWolf);
		johnSnowPets.add(flyingDove);
		johnSnow.setPets(johnSnowPets);

		new Service().save(johnSnow);
	}
}
