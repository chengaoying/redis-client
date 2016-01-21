package com.dashuju.redis.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.dashuju.redis.client.util.SerializeUtil;

public class RedisStringTypeCommandTest extends BaseCommandTest{
	
	RedisStringTypeCommand command;
	
	@Before
	public void before(){
		this.init();
		command = new RedisStringTypeCommand(pool);
	}
	
	@Test
	public void del(){
		command.del("key3");
	}
	
	@Test
	public void delMore(){
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("key2");
		keys.add("key4");
		command.del(keys);
	}
	
	@Test
	public void expire(){
		command.expire(SerializeUtil.serialize("object"), 50);
	}

	@Test
	public void set(){
		command.set("key123", "value123");
	}
	
	@Test
	public void get(){
		command.get("key123");
	}
	
	@Test
	public void setByte(){
		command.setByte("key2".getBytes(), "test".getBytes());
	}
	
	@Test
	public void getByte(){
		command.getByte("key2".getBytes());
	}
	
	@Test
	public void mset(){
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("key3");
		keys.add("key4");
		ArrayList<String> vals = new ArrayList<String>();
		vals.add("val3");
		vals.add("val4");
		command.mset(keys, vals);
	}
	
	@Test
	public void mget(){
		ArrayList<String> keys = new ArrayList<String>();
		keys.add("key3");
		keys.add("key4");
		ArrayList<String> vals = command.mget(keys);
		for (String string : vals) {
			System.out.println(string);
		}
	}
	
	@Test
	public void incr(){
		command.incr("age");
	}
	
	@Test
	public void incrBy(){
		command.incrBy("age", 5);
	}
	
	@Test
	public void append(){
		command.append("name", "jc");
	}
	
	@Test
	public void decr(){
		command.decr("age");
	}
	
	@Test
	public void decrBy(){
		command.decrBy("age", 5);
	}
	
	@Test
	public void substr(){
		command.substr("name", 2, 4);
	}
	
	@Test
	public void strlen(){
		command.strlen("name");
	}
	
	@Test
	public void setObject(){
		List<People> list = new ArrayList<>();
		for(int i=0;i<5;i++){
			People p = new People("jc"+i,i);
			list.add(p);
		}
		command.setObject("object",list);
	}
	
	@Test
	public void getObject(){
		@SuppressWarnings("unchecked")
		List<People> list = (List<People>) command.getObject("object");
		for (People people : list) {
			System.out.println(people.getName());
			System.out.println(people.getAge());
		}
	}
	
}
