package com.dengji85.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dengji85.demo.domain.User;
import com.dengji85.demo.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(DemoApplication.class)
public class TestMapper {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findByName() throws Exception {
		User u = userMapper.findByName("name0");
		Assert.assertEquals("email0@.com", u.getEmail());
	}

}
