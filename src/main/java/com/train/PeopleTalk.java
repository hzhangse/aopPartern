package com.train;

public class PeopleTalk implements ITalk {
	String name;
	Integer age;

	public PeopleTalk() {

	}

	public PeopleTalk(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void talk() {
		System.out.println("people talk");

	}

}
