package com.fcmmmmmm.entity;

import java.math.BigInteger;


public class Student {
	BigInteger id;
	String name;
	int age;

	public Student() {
		super();
	}

	public Student(BigInteger id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
