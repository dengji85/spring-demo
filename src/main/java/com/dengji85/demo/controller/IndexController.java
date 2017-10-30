package com.dengji85.demo.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	public String index(ModelMap model){
		model.addAttribute("time", new Date().toString());
		return "index";
	}
}
