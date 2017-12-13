package com.will.ceil.serviceImpl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "core")
public class CoreE {
	
	@Id
	@GeneratedValue(generator="coreUUID")
	@GenericGenerator(name="coreUUID",strategy="uuid")
	String Id;

	String name;
	
 	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER, optional = false)
 	@JoinColumn(name="ceil_id",insertable=false,updatable=false)
	CeilE ceil;
	
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
	public CeilE getCeil() {
		return ceil;
	}
	public void setCeil(CeilE ceilId) {
		this.ceil = ceilId;
	}
	
}
