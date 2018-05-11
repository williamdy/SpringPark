package com.will.utils;

import com.will.ceil.service.Core;
import com.will.ceil.serviceImpl.CoreE;

public class MockUtil {
	public static Core mockCore(){
		Core core = new Core();
//		core.setId(id);
		core.setName("TESTCORE" + System.currentTimeMillis());
		return core;
	}
	
	public static CoreE mockCoreE(){
		CoreE core = new CoreE();
//		core.setId(id);
		core.setName("TESTCORE" + System.currentTimeMillis());
		return core;
	}
}
