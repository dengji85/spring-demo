package com.dengji85.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dengji85.demo.exception.MyException;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String hello() throws Exception {
		throw new Exception("错误");
	}
	@RequestMapping("/json")
	public String json() throws Exception {
		throw new MyException("错误");
	}
}
