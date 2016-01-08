package com.dashuju.redis.client;

import java.io.Serializable;

public class People implements Serializable{
		
		private static final long serialVersionUID = 5550434844914379587L;
		
		String name;
		int age;
		public People(String name, int age) {
			super();
			this.name = name;
			this.age = age;
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