package com.will.ceil.service;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


public class Core {
	
	String Id;

	String name;
	
	Ceil ceil;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Ceil getCeil() {
		return ceil;
	}
	public void setCeil(Ceil ceil) {
		this.ceil = ceil;
	}
	
}
