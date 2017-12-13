package com.will.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.will.ceil.service.Core;
import com.will.ceil.service.CoreDaoService;

@RestController
@RequestMapping(path = "/action/core", produces = { "application/json;charset=UTF-8" })
public class CoreAction {
	
	@Autowired
	CoreDaoService coreDaoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String test()  {
		return "FULL LONE";
	}
	
	@RequestMapping(value = "add",method = RequestMethod.POST)
	Core add( @RequestBody Core core){
		core = coreDaoService.add(core);
		return core;
	}
	
	@RequestMapping(value = "del",method = RequestMethod.DELETE)
	Core delete(@RequestParam String id){
		Core ceil = coreDaoService.delete(id);
		return ceil;
	}
	
	@RequestMapping(value = "update",method = RequestMethod.POST)
	Core update(@RequestBody Core core){
		core = coreDaoService.update(core);
		return core;
	}
	
	@RequestMapping(value = "list",method = RequestMethod.GET)
	Page<Core> findByBo(Core search){
		Page<Core> page = coreDaoService.findByBo(search);
		return page;
	}
}
