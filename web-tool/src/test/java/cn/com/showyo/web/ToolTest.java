package cn.com.showyo.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import cn.com.showyo.base.tool.DateTimeUtil;

@SpringBootTest
public class ToolTest {
	
	@Test
	public void dateTimeTest() {
		
		System.out.println(DateTimeUtil.getLastDayOfMonth1(2020, 2));
		
	}

}
