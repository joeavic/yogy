package com.yogy.user.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Service
public class RedisDao {


	final JedisPoolConfig poolConfig = buildPoolConfig();
	JedisPool jedisPool = new JedisPool(poolConfig, "localhost");
	final Jedis jedis = jedisPool.getResource();

	private JedisPoolConfig buildPoolConfig() {
		final JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxTotal(128);
		poolConfig.setMaxIdle(128);
		poolConfig.setMinIdle(16);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setTestWhileIdle(true);
		poolConfig.setMinEvictableIdleTimeMillis(Duration.ofSeconds(60).toMillis());
		poolConfig.setTimeBetweenEvictionRunsMillis(Duration.ofSeconds(30).toMillis());
		poolConfig.setNumTestsPerEvictionRun(3);
		poolConfig.setBlockWhenExhausted(true);
		return poolConfig;
	}


	public void set(String key, String value){
		jedis.set(key, value);
	}

	public void sadd(String key, String value){
		jedis.sadd(key, value);
	}


}
