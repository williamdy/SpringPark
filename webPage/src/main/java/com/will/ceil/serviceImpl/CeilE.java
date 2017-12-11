package com.will.ceil.serviceImpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
	
}
