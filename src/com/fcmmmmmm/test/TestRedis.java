package com.fcmmmmmm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fcmmmmmm.config.RedisConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RedisConfig.class)
public class TestRedis {
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Test
	public void test() {
		redisTemplate.opsForValue().set("2122", new String("我爱你"));
	}
}
