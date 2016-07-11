package org.elobanova.service;

import java.util.Calendar;

import org.elobanova.model.Family;
import org.elobanova.model.Land;
import org.elobanova.model.Person;
import org.elobanova.model.Pet;
import org.elobanova.model.Sword;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Service {
	private static final int PRIM_KEY = 1;
	private final SessionFactory sessionFactory;
	private static Service instance;

	private Service() {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static Service getInstance() {
		if (instance == null) {
			instance = new Service();
		}

		return instance;
	}

	public void save(Object person) {
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
		session.getTransaction().commit();

		// does good with eager
		session.close();
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
		direWolf.setNickName("Ghost");
		direWolf.setAlive(true);

		Pet flyingDove = new Pet();
		flyingDove.setNickName("John Snow's Flying Dove A319");
		flyingDove.setAlive(true);

		johnSnow.getPets().add(direWolf);
		johnSnow.getPets().add(flyingDove);
		
		Person ariaStark = new Person();
		ariaStark.setFirstName("Aria Stark");
		Service.getInstance().save(ariaStark);
		
		Land land = new Land();
		land.setLandName("Westeros");
		Service.getInstance().save(land);
		johnSnow.setHomeLand(land);
		Service.getInstance().save(johnSnow);
		
		Family starks = new Family();
		starks.setLastName("Starks Owners of the North");
		starks.getMembers().add(johnSnow);
		starks.getMembers().add(ariaStark);
		Service.getInstance().save(starks);
	}
}
