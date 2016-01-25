package com.dashuju.redis.client;

import java.util.ArrayList;

import redis.clients.jedis.ShardedJedis;

/**
 * redis客户端命令抽象类，提供对redis数据库中key的常用操作。
 * @author CGY
 * @date 2015-1-7
 */
public abstract class AbstractRedisClientCommand{

	/**
	 * 连接池
	 */
	protected ShardedJedisSentinelPool shardedJedisSentinelPool;
	
	/**
	 * 连接实例
	 */
	protected ShardedJedis jedis;

	public AbstractRedisClientCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super();
		this.shardedJedisSentinelPool = shardedJedisSentinelPool;
	}
	
	/**
	 * 从连接池中获取一个实例
	 * @return ShardedJedis
	 */
	protected ShardedJedis getJedisInstance(){
		return shardedJedisSentinelPool.getResource();
	}
	
	/** 
     * 删除key 
     * @param key 删除的key 
     * @return 成功则返回删除的条数，失败返回0
     */  
    public Long del(String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.del(key);
    	jedis.close();
    	return l;
    }  
    
    /** 
     * 删除key 
     * @param key 删除的key 
     * @return 成功则返回删除的条数，失败返回0
     */  
    public Long del(byte[] key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.del(key);
    	jedis.close();
    	return l;
    } 
      
    /** 
     * 批量删除key 
     * @param keys 删除的key列表
     * @return 返回成功删除的数据条数 
     */  
    public Long del(ArrayList<String> keys){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long count = 0L;
    	for (String string : keys) {
    		Long l = jedis.del(string);
    		if(l > 0)
    			count++;
		}
    	jedis.close();
    	return count;
    } 
    
    /**
     * 判断key是否存在
     * @param key redis key
     * @return 1:存在, 0:不存在
     */
    public Boolean exists(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Boolean result = jedis.exists(key);
    	jedis.close();
    	return result;
    }
    
    /**
     * 获取key的类型
     * @param key redis key
     * @return key类型
     */
    public String type(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	String result = jedis.type(key);
    	jedis.close();
    	return result;
    }
    
    /**
     * 将key的生命周期设为永久
     * @param key redis key
     * @return key类型
     */
    public Long persist(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long result = jedis.persist(key);
    	jedis.close();
    	return result;
    }
    
    /**
     * 查询key的生命周期
     * @param key redis key
     * @return 返回key的生命周期，-1为永久
     */
    public Long ttl(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long result = jedis.ttl(key);
    	jedis.close();
    	return result;
    }
    
    /** 
     * 设置key的过期时间 
     * @param key redis key 
     * @param seconds 过期时间，单位：秒 
     * @return 1:success, 0:failed 
     */  
    public Long expire(String key, int seconds){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.expire(key, seconds);
    	jedis.close();
    	return l;
    }
    
    /** 
     * 设置key的过期时间 
     * @param key redis key 
     * @param seconds 过期时间，单位：秒 
     * @return 1:success, 0:failed 
     */  
    public Long expire(byte[] key, int seconds){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.expire(key, seconds);
    	jedis.close();
    	return l;
    }
}
