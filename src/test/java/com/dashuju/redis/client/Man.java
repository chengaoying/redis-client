package com.dashuju.redis.client;

import java.io.Serializable;

public class Man implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String sex;
	
	private People people;
	
	public Man(People people, String sex) {
		this.sex = sex;
		this.people = people;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	
}
