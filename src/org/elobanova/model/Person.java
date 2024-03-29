package org.elobanova.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GOT_CHARACTER")
public class Person {

	// if Id is complex, use @EmbeddedID instead of @Id+@Embedded
	@Id
	@Column(name = "CHARACTER_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int personId;

	@Column(name = "CHARACTER_NAME")
	private String firstName;

	@Temporal(TemporalType.DATE)
	@Column(name = "KILL_DATE")
	private Date wasKilledAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "BORN_DATE")
	private Date bornDate;

	// in case there will be a second field stolenSword of type Sword
	@AttributeOverrides({
			@AttributeOverride(name = "length", column = @Column(name = "OWN_SWORD_LENGTH")),
			@AttributeOverride(name = "forgedAt", column = @Column(name = "OWN_SWORD_FORGE_AT")) })
	private Sword sword;

	@Lob
	private String loveStoryDescription;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Pet> pets = new ArrayList<>();

	@OneToOne
	@JoinColumn(name = "HOME_LAND_ID")
	private Land homeLand;

	@ManyToMany
	private Collection<Family> families = new ArrayList<>();

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

	public Sword getSword() {
		return sword;
	}

	public void setSword(Sword sword) {
		this.sword = sword;
	}

	public Date getBornDate() {
		return bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public Collection<Pet> getPets() {
		return pets;
	}

	public void setPets(Collection<Pet> pets) {
		this.pets = pets;
	}

	public Land getHomeLand() {
		return homeLand;
	}

	public void setHomeLand(Land homeLand) {
		this.homeLand = homeLand;
	}

	public Collection<Family> getFamilies() {
		return families;
	}

	public void setFamilies(Collection<Family> families) {
		this.families = families;
	}
}
