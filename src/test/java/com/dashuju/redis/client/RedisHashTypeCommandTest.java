package com.dashuju.redis.client;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RedisHashTypeCommandTest extends BaseCommandTest{
	
	RedisHashTypeCommand command;

	@Before
	public void before(){
		this.init();
		command = new RedisHashTypeCommand(pool);
	}
	
	@Test
	public void testhmset() throws Exception {
		Map<String, String> map = new HashMap<>();
		map.put("field1", "value1");
		map.put("field2", "value2");
		map.put("field3", "value3");
		command.hmset("map1", map);
	}
	
	@Test
	public void testhmget() throws Exception {
		System.out.println(command.hmget("map1","field1"));
	}
	
	@Test
	public void testhkeys() throws Exception {
		System.out.println(command.hkeys("map1"));
	}
	
	@Test
	public void testhvals() throws Exception {
		System.out.println(command.hvals("map1"));
	}
	
	@Test
	public void testhlen() throws Exception {
		System.out.println(command.hlen("map1"));
	}
	
	@Test
	public void testhdel() throws Exception {
		System.out.println(command.hdel("map1","field2"));
	}
	
	@Test
	public void testhexists() throws Exception {
		System.out.println(command.hexists("map1","field2"));
	}
	
}
