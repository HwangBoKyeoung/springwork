package co.micol.prj.ord;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.micol.prj.ord.service.OrdService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/config/*-context.xml")
public class OrderServiceClient {
	
	@Autowired
	OrdService ordService;
	
	@Test
	public void test() {
		String data="테스트입니다1111111222.";
		int r = ordService.insert(data);
		assertEquals(r, 1);
	}
}
