package com.will.ceil.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CeilDaoService {

	Ceil add(Ceil ceil);
	
	Ceil delete(String id);
	
	Ceil update(Ceil ceil);
	
	Page<Ceil> findByBo(Ceil search);
}
