package com.ty.Hospital_boot.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Encounter {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int admitionId;
	
	
	@NotNull
	private  String reson;
	
	
	public int getAdmitionId() {
		return admitionId;
	}
	public void setAdmitionId(int admitionId) {
		this.admitionId = admitionId;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	
	
	
}
