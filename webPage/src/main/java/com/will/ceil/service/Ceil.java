package com.will.ceil.service;

import java.util.Set;

import com.will.ceil.serviceImpl.CoreE;


public class Ceil {

	String Id;
	String name;
	Set <Core> cores;
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
	public Set<Core> getCores() {
		return cores;
	}
	public void setCores(Set<Core> cores) {
		this.cores = cores;
	}
	
}
