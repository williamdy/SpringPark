package com.will.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.will.ceil.service.Ceil;
import com.will.ceil.service.CeilDaoService;

@RestController
@RequestMapping(path = "/action/test", produces = { "application/json;charset=UTF-8" })
public class TestClass {
	
	@Autowired
	CeilDaoService ceilDaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String test()  {
		return "FULL LONE";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	Ceil add( @RequestBody Ceil ceil){
		ceil = ceilDaoService.add(ceil);
		return ceil;
	}
	
	@RequestMapping(value = "del",method = RequestMethod.DELETE)
	Ceil delete(@RequestParam String id){
		Ceil ceil = ceilDaoService.delete(id);
		return ceil;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	Ceil update(@RequestBody Ceil ceil){
		ceil = ceilDaoService.update(ceil);
		return ceil;
	}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	Page<Ceil> findByBo(Ceil search){
		Page<Ceil> page = ceilDaoService.findByBo(search);
		return page;
	}
}
