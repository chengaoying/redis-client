package com.dashuju.redis.client;

import java.util.ArrayList;

import com.dashuju.redis.client.util.SerializeUtil;

import redis.clients.jedis.ShardedJedis;

/**
 * reids中 String类型数据操作常用命令
 * @author CGY
 * @date 2015-1-7
 */
public class RedisStringTypeCommand extends AbstractRedisClientCommand{

	public RedisStringTypeCommand(ShardedJedisSentinelPool shardedJedisSentinelPool) {
		super(shardedJedisSentinelPool);
	}

	/** 
     * 插入String类型数据 
     * @param key 插入的key 
     * @param value 插入的value 
     * @return 成功返回"OK",插入失败返回NULL 
     */
	public String set(final String key, String value){
		ShardedJedis jedis = this.getJedisInstance();
		String result = jedis.set(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 获取String类型数据
     * @param key redis key 
     * @return 成功返回value,查询不到返回NULL 
     */
	public String get(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		String val = jedis.get(key);
		jedis.close();
		return val;
	}
	
	/** 
     * 批量插入String类型数据
     * @param keys 插入的键列表 
     * @param values 插入的值列表 
     */  
    public void mset(final ArrayList<String> keys, final ArrayList<String> values){
    	for (int i = 0; i < keys.size(); i++) {
			this.set(keys.get(i), values.get(i));
		}
    }  
    
    /** 
     * 批量读取String类型数据 
     * @param keys 查询的key列表
     * @return 返回值列表
     */ 
    public ArrayList<String> mget(final ArrayList<String> keys){
    	ArrayList<String> vals = new ArrayList<String>();
    	for (int i = 0; i < keys.size(); i++) {
    		vals.add(this.get(keys.get(i)));
		}
    	return vals;
    }
    
    /**
     * 数值类型递增1
     * @param key redis key
     * @return long  递增后的值
     */
    public Long incr(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.incr(key);
    	jedis.close();
    	return l;
    }
    
    /**
     * 数值类型加value
     * @param key redis key
     * @param value 增加的值
     * @return long  递增后的值
     */
    public Long incrBy(final String key, final int value){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.incrBy(key,value);
    	jedis.close();
    	return l;
    }
    
    /**
     * 数值类型递减1
     * @param key redis key
     * @return long  减去后的值
     */
    public Long decr(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.decr(key);
    	jedis.close();
    	return l;
    }
    
    /**
     * 数值类型减value
     * @param key redis key
     * @param value 减去的值
     * @return long  减去后的值
     */
    public Long decrBy(final String key, final int value){
    	ShardedJedis jedis = this.getJedisInstance();
    	Long l = jedis.decrBy(key,value);
    	jedis.close();
    	return l;
    }
    
    /** 
     * 追加字符串
     * @param key redis key 
     * @param value 追加的value 
     * @return 返回字符串长度 
     */
	public Long append(final String key, String value){
		ShardedJedis jedis = this.getJedisInstance();
		long result = jedis.append(key, value);
		jedis.close();
		return result;
	}
	
	/** 
     * 获取key对应的value长度
     * @param key redis key 
     * @return 返回字符串长度 
     */
	public Long strlen(final String key){
		ShardedJedis jedis = this.getJedisInstance();
		long result = jedis.strlen(key);
		jedis.close();
		return result;
	}
	
	/** 
     * 截取key对应的value的值
     * @param key redis key 
     * @param start 起始位置 
     * @param end 结束位置
     * @return 返回子字符串
     */
	public String substr(final String key, final int start, final int end){
		ShardedJedis jedis = this.getJedisInstance();
		String val = jedis.substr(key, start, end);
		jedis.close();
		return val;
	}
    
    /** 
     * 插入字节数组到Redis中 
     * @param key 插入的key 
     * @param value 插入的字节数组 value 
     * @return 成功返回"OK",插入失败返回NULL 
     */  
    public String setByte(final String key, final byte[] value){
    	ShardedJedis jedis = this.getJedisInstance();
    	String result = jedis.set(key.getBytes(), value);
    	jedis.close();
    	return result;
    } 
      
      
    /** 
     * 通过key获取value 
     * @param key redis中的key 
     * @return 成功返回value,查询不到返回NULL 
     */  
    public byte[] getByte(final String key){
    	ShardedJedis jedis = this.getJedisInstance();
    	byte[] value = jedis.get(key.getBytes());
    	jedis.close();
    	return value;
    } 
    
    /**
     * 插入对象对redis中
     * @param key  插入的对象 key
     * @param object  插入的对象object
     * @return  成功返回"OK",插入失败返回NULL
     */
    public String setObject(final String key, final Object object){
    	return this.setByte(key, SerializeUtil.serialize(object));
    }
    
    /**
     * 获取对象
     * @param key 查询的 key
     * @return object 返回插入的对象
     */
    public Object getObject(final String key){
    	return SerializeUtil.unserialize(this.getByte(key));
    }
      
}
