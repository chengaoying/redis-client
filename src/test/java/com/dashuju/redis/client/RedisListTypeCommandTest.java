package com.dashuju.redis.client;

import org.junit.Before;
import org.junit.Test;

public class RedisListTypeCommandTest extends BaseCommandTest{
	
	RedisListTypeCommand command;

	@Before
	public void before(){
		this.init();
		command = new RedisListTypeCommand(pool);
	}
	
	@Test
	public void testLpush() throws Exception {
		command.lpush("key0", new String[]{"val1","val2","val3"});
	}
	
	@Test
	public void testRpush() throws Exception {
		command.rpush("key1", new String[]{"val1","val2","val3"});
	}
	
	@Test
	public void testlpushx() throws Exception {
		System.out.println(command.lpushx("key2", "val2"));;
	}
	
	@Test
	public void testrpushx() throws Exception {
		System.out.println(command.rpushx("key3", "val2"));
	}
	
	@Test
	public void testllen() throws Exception {
		System.out.println(command.llen("key3"));
	}
	
	@Test
	public void testlpop() throws Exception {
		System.out.println(command.lpop("key3"));
	}
	
	@Test
	public void testrpop() throws Exception {
		System.out.println(command.rpop("key3"));
	}
	
	@Test
	public void testlindex() throws Exception {
		System.out.println(command.lindex("key3",0));
	}
	
	@Test
	public void testlrange() throws Exception {
		System.out.println(command.lrange("key3",0,3));
	}
	
	@Test
	public void testlrem() throws Exception {
		System.out.println(command.lrem("key3",-1,"val2"));
	}
	
	@Test
	public void testlset() throws Exception {
		System.out.println(command.lset("key3",0,"val2"));
	}
	
	@Test
	public void testltrim() throws Exception {
		System.out.println(command.ltrim("key3",0,1));
	}
	
}
