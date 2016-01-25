package com.dashuju.redis.client;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dashuju.redis.client.util.SerializeUtil;

import redis.clients.jedis.ShardedJedis;

/**
 * 哈希（Hash）类型数据操作常用命令
 * @author CGY
 * @date 2015-1-7
 */
public class RedisHashTypeCommand extends AbstractRedisClientCommand{


	public RedisHashTypeCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super(shardedJedisSentinelPool);
	}

	/** 
     * 插入一个哈希结构的数据
     * @param key 哈希在redis中key值 
     * @param value 插入的hashMap
     * @return 成功返回"OK"
     */
	public String hmset(final String key, final Map<String, String> value){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.hmset(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 插入一个哈希结构的数据
     * @param key 哈希在redis中key值 
     * @param field 插入的hashMap中的field
     * @param value 插入的hashMap中的value
     * @return 成功返回插入条数
     */
	public Long hset(final Object key, final Object field, final Object value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.hset(SerializeUtil.serialize(key), SerializeUtil.serialize(field), SerializeUtil.serialize(value));
		jedis.close();
		return result;
	}
	
	/** 
     * 查询哈希key中字段field的值
     * @param key 哈希在redis中key值 
     * @param filed 查询的字段
     * @return list
     */
	public List<String> hmget(final String key, final String... filed){
		ShardedJedis jedis = this.getJedisInstance();
		List<String> result = jedis.hmget(key, filed);
		jedis.close();
		return result;
	}
	
	/**
	 * 查询哈希key中的field的值
	 * @param key  哈希在redis中key值
	 * @param field 查询的字段
	 * @return object
	 */
	public Object hget(final Object key, final Object field){
		ShardedJedis jedis = this.getJedisInstance();
		byte[] result = jedis.hget(SerializeUtil.serialize(key), SerializeUtil.serialize(field));
		jedis.close();
		return SerializeUtil.unserialize(result);
	}
	
	/** 
     * 查询哈希key中所有的字段
     * @param key 哈希在redis中key值 
     * @return set
     */
	public Set<String> hkeys(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.hkeys(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 查询哈希key中所有的值
     * @param key 哈希在redis中key值 
     * @return list
     */
	public List<String> hvals(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		List<String> result = jedis.hvals(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 查询哈希key的长度
     * @param key hash在redis中key值 
     * @return long 
     */
	public Long hlen(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.hlen(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 查询哈希key中一个或多字段
     * @param key hash在redis中key值 
     * @param field 删除的字段
     * @return 返回删除的个数
     */
	public Long hdel(final String key, final String... field){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.hdel(key,field);
		jedis.close();
		return result;
	}
	
	/** 
     * 判断哈希key中field是否存在
     * @param key hash在redis中key值 
     * @param field 查询字段
     * @return 存在返回true
     */
	public Boolean hexists(final String key, final String field){
		ShardedJedis jedis = this.getJedisInstance();
		Boolean result = jedis.hexists(key,field);
		jedis.close();
		return result;
	}
	
}
