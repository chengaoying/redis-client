package com.dashuju.redis.client;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.ShardedJedis;

/**
 * 集合（Set）类型数据操作常用命令
 * @author CGY
 * @date 2015-1-7
 */
public class RedisSetTypeCommand extends AbstractRedisClientCommand{

	public RedisSetTypeCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super(shardedJedisSentinelPool);
	}

	/** 
     * 添加一个或者多个元素到集合(set)里 
     * @param key 集合key 
     * @param value 插入的value 
     * @return 成功返回插入集合的个数
     */
	public Long sadd(final String key, final String... value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.sadd(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 获取集合里面的元素数量 
     * @param key 集合key 
     * @return 返回集合的个数 
     */
	public Long scard(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.scard(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 获取集合里面的所有key
     * @param key 集合key 
     * @return set 
     */
	public Set<String> smembers(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.smembers(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 从集合里面随机获取count个元素
     * @param key 集合key 
     * @param count 元素个数，可为空 
     * @return 元素列表 
     */
	public List<String> srandmember(final String key, final int count){
		ShardedJedis jedis = this.getJedisInstance();
		List<String> result = jedis.srandmember(key,count);
		jedis.close();
		return result;
	}
	
	/** 
     * 从集合里删除一个或多个key
     * @param key 集合key 
     * @param value 删除的元数值
     * @return 删除的个数 
     */
	public Long srem(final String key, final String... value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.srem(key,value);
		jedis.close();
		return result;
	}
	
}
