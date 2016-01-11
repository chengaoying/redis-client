package com.dashuju.redis.client;

import java.util.List;

import redis.clients.jedis.ShardedJedis;

/**
 * List类型数据操作常用命令
 * @author CGY
 * @date 2015-1-7
 */
public class RedisListTypeCommand extends AbstractRedisClientCommand{

	public RedisListTypeCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super(shardedJedisSentinelPool);
	}

	/** 
     * 从队列的左边入队一个或多个元素 
     * @param key 队列key 
     * @param value 插入的value 
     * @return 成功返回插入队列的个数,插入失败返回NULL
     */
	public Long lpush(final String key, final String... value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.lpush(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 从队列的右边入队一个或多个元素 
     * @param key 队列key 
     * @param value 插入的value 
     * @return 成功返回插入队列的个数,插入失败返回NULL 
     */
	public Long rpush(final String key, final String... value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.rpush(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 当队列存在时，从队到左边入队一个元素
     * @param key 队列key 
     * @param value 插入的value 
     * @return 成功返回插入队列的个数,插入失败返回NULL 
     */
	public Long lpushx(final String key, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.lpushx(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 当队列存在时，从队到右边入队一个元素
     * @param key 队列key 
     * @param value 插入的value 
     * @return 成功返回插入队列的个数,插入失败返回NULL 
     */
	public Long rpushx(final String key, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.rpushx(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 获得队列(List)的长度
     * @param key 队列key 
     * @return 返回队列长度
     */
	public Long llen(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.llen(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 从队列的左边出队一个元素
     * @param key 队列key 
     * @return 返回队列左边第一个元素
     */
	public String lpop(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.lpop(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 从队列的右边出队一个元素
     * @param key 队列key 
     * @return 返回队列右边第一个元素
     */
	public String rpop(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.rpop(key);
		jedis.close();
		return result;
	}
	
	/**
	 * 通过其索引获取一个元素
	 * @param key 队列key
	 * @param index 元素索引值
	 * @return 请求的对应元素，或者当 index 超过范围的时候返回 null
	 */
	public String lindex(final String key, final int index){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.lindex(key,index);
		jedis.close();
		return result;
	}
	
	/** 
     * 从列表中获取指定返回的元素
     * @param key 队列key 
     * @param start 开始位置
     * @param end 结束位置
     * @return 元素列表
     */
	public List<String> lrange(final String key, final int start, final int end){
		ShardedJedis jedis = this.getJedisInstance();
		List<String> result = jedis.lrange(key,start,end);
		jedis.close();
		return result;
	}
	
	/** 
     * 从存于 key 的列表里移除前 count 次出现的值为 value 的元素
     * @param key 队列key 
     * @param count 元素出现的次数：count > 0:从头往尾移除值为 value 的元素。count < 0:从尾往头移除值为 value 的元素。count = 0:移除所有值为 value 的元素。 
     * @param value 队列中存在的value 
     * @return 被移除的元素个数
     */
	public Long lrem(final String key, final int count, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.lrem(key,count,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 设置队列第index位置的值为value
     * @param key 队列key 
     * @param index 队列位置
     * @param value 设置的value 
     * @return 成功返回ok，失败返回null
     */
	public String lset(final String key, final int index, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.lset(key,index,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 截取队列长度
     * @param key 队列key 
     * @param start 开始位置
     * @param end 结束位置
     * @return 成功返回ok，失败返回null
     */
	public String ltrim(final String key, final int start, final int end){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.ltrim(key,start,end);
		jedis.close();
		return result;
	}
	
}
