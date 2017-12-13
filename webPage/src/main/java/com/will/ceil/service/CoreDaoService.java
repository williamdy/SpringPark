package com.will.ceil.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface CoreDaoService {

	Core add(Core Core);
	
	Core delete(String id);
	
	Core update(Core Core);
	
	Page<Core> findByBo(Core search);
}
