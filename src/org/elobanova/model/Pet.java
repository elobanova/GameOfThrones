package org.elobanova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOT_PET")
public class Pet {
	@Id
	@Column(name = "PET_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int petId;

	@Column(name = "PET_NAME")
	private String nickName;
	private boolean isAlive;

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
}
