package com.flhscl.springbootscrafhold;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootscrafholdApplication.class)
public class SpringbootscrafholdApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void test() throws Exception {
		// 保存字符串
		stringRedisTemplate.opsForValue().set("aaa", "111");
		stringRedisTemplate.opsForValue().set("aab", "111");
		stringRedisTemplate.opsForValue().set("aac", "11c");
		Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
	}
}
