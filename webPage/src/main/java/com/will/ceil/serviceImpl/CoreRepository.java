package com.will.ceil.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CoreRepository extends JpaRepository<CoreE, String>,
		JpaSpecificationExecutor<CoreE> {

}
