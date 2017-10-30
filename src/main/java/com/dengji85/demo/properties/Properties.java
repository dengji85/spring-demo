package com.dengji85.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	@Value("${com.dengji85.demo.name}")
	private String name;
	@Value("${com.dengji85.demo.title}")
	private String title;
	@Value("${com.dengji85.demo.desc}")
	private String desc;
	@Value("${com.dengji85.demo.value}")
	private String value;
	@Value("${com.dengji85.demo.number}")
	private int number;
	@Value("${com.dengji85.demo.bignumber}")
	private long bignumber;
	@Value("${com.dengji85.demo.test1}")
	private int test1;
	@Value("${com.dengji85.demo.test2}")
	private int test2;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public long getBignumber() {
		return bignumber;
	}

	public void setBignumber(long bignumber) {
		this.bignumber = bignumber;
	}

	public int getTest1() {
		return test1;
	}

	public void setTest1(int test1) {
		this.test1 = test1;
	}

	public int getTest2() {
		return test2;
	}

	public void setTest2(int test2) {
		this.test2 = test2;
	}

}
