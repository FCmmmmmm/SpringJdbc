package com.fcmmmmmm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
//@EnableRedisRepositories
public class RedisConfig {
	@Bean
	public RedisConnectionFactory redisCF() {
		JedisConnectionFactory jedisConnection=new JedisConnectionFactory();
		jedisConnection.setHostName("127.0.0.1");
		jedisConnection.setPort(6379);
		return jedisConnection;
	}
	
	@Bean
	public StringRedisTemplate stringRedisTemplate(){
		StringRedisTemplate sTemplate=new StringRedisTemplate(redisCF());
		return sTemplate;
	}
	
	@Bean
	public RedisTemplate<String, Object>redisTemplate(){
		RedisTemplate<String, Object> redisTemplate=new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisCF());
		return redisTemplate;
	}
}
