package org.elobanova.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

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

	public void save(Collection<?> objects) {
		if (objects == null || objects.isEmpty()) {
			// log and return
			return;
		}

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		objects.stream().forEach(object -> session.save(object));
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
		direWolf.setNickName("John Snow's Dire Wolf Puff");
		direWolf.setAlive(false);

		Pet flyingDove = new Pet();
		flyingDove.setNickName("John Snow's Flying Dove A319");
		flyingDove.setAlive(true);

		johnSnow.getPets().add(direWolf);
		johnSnow.getPets().add(flyingDove);

		Land land = new Land();
		land.setLandName("Westeros");

		Person ariaStark = new Person();
		ariaStark.setFirstName("Aria Stark");
		ariaStark.setHomeLand(land);

		johnSnow.setHomeLand(land);

		Family starks = new Family();
		starks.setLastName("Starks Owners of the North");
		Family targaryens = new Family();
		targaryens.setLastName("Targaryens with Fire and Blood");

		starks.getMembers().add(johnSnow);
		starks.getMembers().add(ariaStark);
		targaryens.getMembers().add(johnSnow);

		ariaStark.getFamilies().add(starks);
		johnSnow.getFamilies().add(starks);
		johnSnow.getFamilies().add(targaryens);

		Collection<Object> objectsToSave = new ArrayList<>();
		objectsToSave.add(land);
		objectsToSave.add(ariaStark);
		objectsToSave.add(johnSnow);
		objectsToSave.add(targaryens);
		objectsToSave.add(starks);
		Service.getInstance().save(objectsToSave);
	}
}
