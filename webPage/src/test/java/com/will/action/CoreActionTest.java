package com.will.action;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.will.App;
import com.will.ceil.service.Core;
import com.will.ceil.service.CoreDaoService;
import com.will.utils.MockUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
public class CoreActionTest {

	@Autowired
	CoreAction coreAction;
//
//	@Mock
//	CoreDaoService coreDaoService;

	@Before
	public void setup() {

		MockitoAnnotations.initMocks(this);// 这句话执行以后，aaaDao和bbbDao自动注入到abcService中。

		// 在这之后，你就可以放心大胆地使用when().then()等进行更详细的设置。

	}

	@Test
	public void test() {
		Core core = MockUtil.mockCore();
 		Core result = coreAction.add(core );
		Assert.assertNotNull(result);
	}

}
