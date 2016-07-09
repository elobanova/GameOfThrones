package org.elobanova.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Sword has no meaning outside of the person
@Embeddable
public class Sword {

	@Temporal(TemporalType.DATE)
	@Column(name = "FORGE_DATE")
	private Date forgedAt;

	@Column(name = "SWORD_LENGTH")
	private double length;

	public Date getForgedAt() {
		return forgedAt;
	}

	public void setForgedAt(Date forgedAt) {
		this.forgedAt = forgedAt;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
}
