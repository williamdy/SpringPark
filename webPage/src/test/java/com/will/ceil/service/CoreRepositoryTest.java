package com.will.ceil.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.App;
import com.will.ceil.serviceImpl.CoreE;
import com.will.ceil.serviceImpl.CoreRepository;
import com.will.utils.MockUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CoreRepositoryTest {
	
//	@InjectMocks 
	@Autowired
	CoreRepository coreRepository;
	
	@Before
	public void setup() {

// 		MockitoAnnotations.initMocks(this);// 这句话执行以后，aaaDao和bbbDao自动注入到abcService中。

		// 在这之后，你就可以放心大胆地使用when().then()等进行更详细的设置。

	}
	
	@Test
	public void test() {
		CoreE core = MockUtil.mockCoreE();
 		CoreE result = new CoreE();
// 		Page<Core> page = null;
// 		Mockito.when(coreDaoService.findByBo(core)).thenReturn( page);
 		
		// 		System.out.println(page.getSize());
 		result = coreRepository.saveAndFlush(core);
// 		Mockito.when( coreRepository.saveAndFlush(entity)).thenReturn( result);
 		System.out.println(result.getName());
		Assert.assertNotNull(result);
	}
}
