package org.elobanova.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GOT_FAMILY")
public class Family {
	@Id
	@Column(name = "FAMILY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@Column(name = "FAMILY_LAST_NAME")
	private String lastName;

	@ManyToMany(mappedBy = "families")
	private Collection<Person> members = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Collection<Person> getMembers() {
		return members;
	}

	public void setMembers(Collection<Person> members) {
		this.members = members;
	}
}
