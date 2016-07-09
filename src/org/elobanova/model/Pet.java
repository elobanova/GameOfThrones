package org.elobanova.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pet {
	@Id
	private int petId;
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
