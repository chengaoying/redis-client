package com.dashuju.redis.client;

import org.junit.Before;
import org.junit.Test;

public class RedisOrderSetTypeCommandTest extends BaseCommandTest{
	
	RedisOrderSetTypeCommand command;

	@Before
	public void before(){
		this.init();
		command = new RedisOrderSetTypeCommand(pool);
	}
	
	@Test
	public void testzadd() throws Exception {
		command.zadd("zet1", 1, "value2");
	}
	
	@Test
	public void testzcard() throws Exception {
		System.out.println(command.zcard("zet1"));
	}
	
	@Test
	public void testzcount() throws Exception {
		System.out.println(command.zcount("zet1",1,3));
	}
	
	@Test
	public void testzincrby() throws Exception {
		System.out.println(command.zincrby("zet1",3,"value2"));
	}
	
	@Test
	public void testzrangeByScore() throws Exception {
		System.out.println(command.zrangeByScore("zet1",1,30));
	}
	
	@Test
	public void testzscore() throws Exception {
		System.out.println(command.zscore("zet1","value2"));
	}
	
	@Test
	public void testzrank() throws Exception {
		System.out.println(command.zrank("zet1","value2"));
	}
	
	@Test
	public void testzrevrank() throws Exception {
		System.out.println(command.zrevrank("zet1","value2"));
	}
	
	@Test
	public void testzrem() throws Exception {
		System.out.println(command.zrem("zet1","value2"));
	}
	
	@Test
	public void testzrange() throws Exception {
		System.out.println(command.zrange("zet1",0,30));
	}
	
	@Test
	public void testzrevrange() throws Exception {
		System.out.println(command.zrevrange("zet1",0,30));
	}
	
	@Test
	public void testzrevrangeByScore() throws Exception {
		System.out.println(command.zrevrangeByScore("zet1",30,3));
	}
	
}
