package com.will.ceil.serviceImpl;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "ceil")
public class CeilE {
	
	@Id
	@GeneratedValue(generator="ceilUUID")
	@GenericGenerator(name="ceilUUID",strategy="uuid")
	String Id;

	String name;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	Set <CoreE> cores;
	
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
	public Set<CoreE> getCores() {
		return cores;
	}
	public void setCores(Set<CoreE> cores) {
		this.cores = cores;
	}
	
}
