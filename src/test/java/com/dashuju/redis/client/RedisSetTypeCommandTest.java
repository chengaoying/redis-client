package com.dashuju.redis.client;

import org.junit.Before;
import org.junit.Test;

public class RedisSetTypeCommandTest extends BaseCommandTest{
	
	RedisSetTypeCommand command;

	@Before
	public void before(){
		this.init();
		command = new RedisSetTypeCommand(pool);
	}
	
	@Test
	public void testsadd() throws Exception {
		command.sadd("set1", new String[]{"value1","value2"});
	}
	
	@Test
	public void testscard() throws Exception {
		System.out.println(command.scard("set1"));
	}
	
	@Test
	public void testsmembers() throws Exception {
		System.out.println(command.smembers("set1"));
	}
	
	@Test
	public void testsrandmember() throws Exception {
		System.out.println(command.srandmember("set1", 1));
	}
	
	@Test
	public void testsrem() throws Exception {
		System.out.println(command.srem("set1","value1"));
	}
	
}
