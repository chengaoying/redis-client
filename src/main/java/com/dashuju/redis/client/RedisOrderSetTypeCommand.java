package com.dashuju.redis.client;

import java.util.Set;

import redis.clients.jedis.ShardedJedis;

/**
 * 有序集合（OrderSet）类型数据操作常用命令
 * @author CGY
 * @date 2015-1-7
 */
public class RedisOrderSetTypeCommand extends AbstractRedisClientCommand{

	public RedisOrderSetTypeCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super(shardedJedisSentinelPool);
	}

	/** 
     * 添加到有序set的一个或多个成员，或更新的分数，如果它已经存在
     * @param key 集合key 
     * @param score 分数值 
     * @param value 插入的value 
     * @return 成功返回插入集合的个数
     */
	public Long zadd(final String key, final int score, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zadd(key, score, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 获取集合里面的元素数量 
     * @param key 集合key 
     * @return 返回集合的个数 
     */
	public Long zcard(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zcard(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中元素的score值在min和max之间(默认包括score值等于min或max)的成员
     * @param key 集合key 
     * @param min 最小值
     * @param max 最大值 
     * @return 返回符合条件元素的个数 
     */
	public Long zcount(final String key, final int min, final int max){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zcount(key,min,max);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集合key的元素value的score值加上增量score
     * @param key 集合key 
     * @param score 增加的分数值 
     * @param value 元素值
     * @return 返回新的分数值
     */
	public Double zincrby(final String key, final int score, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Double result = jedis.zincrby(key,score,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中，指定区间内的成员
     * @param key 集合key 
     * @param start 开始位置
     * @param end 结束位置
     * @return 返回元素集合
     */
	public Set<String> zrange(final String key, final int start, final int end){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.zrange(key,start,end);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集合key中元素的分数在min和max之间的所有元素
     * @param key 集合key 
     * @param min 最小值
     * @param max 最大值 
     * @return 返回元素集合
     */
	public Set<String> zrangeByScore(final String key, final int min, final int max){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.zrangeByScore(key,min,max);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中，成员value的score值
     * @param key 集合key 
     * @param value 查询元素值
     * @return 返回元素score
     */
	public Double zscore(final String key, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Double result = jedis.zscore(key,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中成员value的排名
     * @param key 集合key 
     * @param value 查询元素值
     * @return 返回元素排名
     */
	public Long zrank(final String key, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zrank(key,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中成员value的排名，其中有序集成员按score值从大到小排列
     * @param key 集合key 
     * @param value 查询元素值
     * @return 返回元素排名
     */
	public Long zrevrank(final String key, final String value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zrevrank(key,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 从有序集合中删除一个或多个成员
     * @param key 集合key 
     * @param value 删除的元数值 
     * @return 返回删除元素的个数 
     */
	public Long zrem(final String key, final String... value){
		ShardedJedis jedis = this.getJedisInstance();
		Long result = jedis.zrem(key,value);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集key中，指定区间内的成员。其中成员的位置按score值递减(从大到小)来排列
     * @param key 集合key 
     * @param start 开始位置
     * @param end 结束位置
     * @return 返回元素集合
     */
	public Set<String> zrevrange(final String key, final int start, final int end){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.zrevrange(key,start,end);
		jedis.close();
		return result;
	}
	
	/** 
     * 查找有序集合key中的分数在max和min之间的所有元素（包括分数等于max或者min的元素）
     * @param key 集合key 
     * @param max 最大值 
     * @param min 最小值
     * @return 返回元素集合
     */
	public Set<String> zrevrangeByScore(final String key, final int max, final int min){
		ShardedJedis jedis = this.getJedisInstance();
		Set<String> result = jedis.zrevrangeByScore(key,max,min);
		jedis.close();
		return result;
	}
}
