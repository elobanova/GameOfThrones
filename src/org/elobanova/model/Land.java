package org.elobanova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GOT_LAND")
public class Land {
	@Id
	@Column(name = "LAND_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(name = "LAND_NAME")
	private String landName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLandName() {
		return landName;
	}

	public void setLandName(String landName) {
		this.landName = landName;
	}

}
