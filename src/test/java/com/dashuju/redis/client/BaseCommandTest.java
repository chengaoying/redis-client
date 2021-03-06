package com.dashuju.redis.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class BaseCommandTest {

	protected ShardedJedisSentinelPool pool;
	
	public void init(){
		GenericObjectPoolConfig config = new GenericObjectPoolConfig();
		
		List<String> masters = new ArrayList<String>();
		masters.add("mymaster");
		
		Set<String> sentinels = new HashSet<String>();
		sentinels.add("112.74.204.238:26379");
    
		pool = new ShardedJedisSentinelPool(masters, sentinels, config, 60000);
	}
}
