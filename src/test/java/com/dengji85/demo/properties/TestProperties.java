package com.dengji85.demo.properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dengji85.demo.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class TestProperties {
	private static final Log log = LogFactory.getLog(TestProperties.class);

	@Autowired
	private Properties p;

	@Test
	public void getpro() {
		Assert.assertEquals(p.getName(), "邓集海abc123");
		Assert.assertEquals(p.getTitle(), "myDemo");

		log.info(p.getDesc());
		log.info(p.getValue());
		log.info(p.getNumber());
		log.info(p.getBignumber());
		log.info(p.getTest1());
		log.info(p.getTest2());
		
	}

}
