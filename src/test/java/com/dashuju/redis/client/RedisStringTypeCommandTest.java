package com.dashuju.redis.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import junit.framework.TestCase;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class RedisStringTypeCommandTest extends TestCase {

	public void testX() throws Exception {
		
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		
		List<String> masters = new ArrayList<String>();
		masters.add("mymaster1");
		masters.add("mymaster2");
		
		Set<String> sentinels = new HashSet<String>();
		sentinels.add("192.168.145.128:26379");
		sentinels.add("192.168.145.128:26479");
    
		ShardedJedisSentinelPool pool = new ShardedJedisSentinelPool(masters, sentinels, config, 60000);
		
		RedisStringTypeCommand command = new RedisStringTypeCommand(pool);
		
		/*----------------common test--------------*/
		//command.del("key3");
		
		/*2.ArrayList<String> keys = new ArrayList<String>();
		keys.add("key2");
		keys.add("key4");
		command.del(keys);*/
		
		//3.command.expire("key123", 5);
		
		
		
		/*----------------String type test--------------*/
		//1.command.set("key123", "value123");
		
		//2.System.out.println(command.get("key123"));
		
		//3.command.setByte("key2", "test".getBytes());
		
		//4.System.out.println(new String(command.getByte("key2")));
		
		/*ArrayList<String> keys = new ArrayList<String>();
		keys.add("key3");
		keys.add("key4");
		ArrayList<String> vals = new ArrayList<String>();
		vals.add("val3");
		vals.add("val4");
		command.mset(keys, vals);*/
		
		//while(true){
			/*ArrayList<String> keys = new ArrayList<String>();
			keys.add("key3");
			keys.add("key4");
			ArrayList<String> vals = command.mget(keys);
			for (String string : vals) {
				System.out.println(string);
			}*/
			
			try {
				System.out.println(command.get("key3"));
            } catch (Exception e) {
                System.out.println(": Cannot connect to Redis");
            } finally {
            }
		//}
		
		
		//7.command.incr("age");
		
		//8.command.incrBy("age", 5);
		
		//9.command.append("name", "jc");
		
		//10.command.decr("age");
		
		//11.command.decrBy("age", 5);
		
		//12.System.out.println(command.substr("name", 2, 4));
		
		//13.System.out.println(command.strlen("name"));
		
		
		//
		/*People t = new People("jc",11);
		command.setObject("object",t);*/
		
		/*People t = (People) command.getObject("object");
		System.out.println(t.getName());
		System.out.println(t.getAge());*/
	}
	
}
