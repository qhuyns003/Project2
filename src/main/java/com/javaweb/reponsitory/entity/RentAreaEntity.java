package com.javaweb.reponsitory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="rentarea")
public class RentAreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="value")
	private Long value;
	
	@ManyToOne
	@JoinColumn(name="buildingid")
	private BuildingEntity buildings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public BuildingEntity getBuildings() {
		return buildings;
	}

	public void setBuildings(BuildingEntity buildings) {
		this.buildings = buildings;
	}

	

	
	
}
