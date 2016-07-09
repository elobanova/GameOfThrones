package org.elobanova.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GOT_CHARACTER")
public class Person {

	@Id
	@Column(name = "CHARACTER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int personId;

	@Column(name = "CHARACTER_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name = "KILL_DATE")
	private Date wasKilledAt;

	private List<Pet> pets;

	@Lob
	private String loveStoryDescription;

	// Capturing the values in fact from the getter
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getWasKilledAt() {
		return wasKilledAt;
	}

	public void setWasKilledAt(Date wasKilledAt) {
		this.wasKilledAt = wasKilledAt;
	}

	public String getLoveStoryDescription() {
		return loveStoryDescription;
	}

	public void setLoveStoryDescription(String loveStoryDescription) {
		this.loveStoryDescription = loveStoryDescription;
	}
}
