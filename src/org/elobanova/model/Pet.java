package org.elobanova.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Pet {
	@Column(name = "PET_NAME")
	private String nickName;
	private boolean isAlive;

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
