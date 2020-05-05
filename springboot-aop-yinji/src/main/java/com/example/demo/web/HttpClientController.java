package com.example.demo.web;

import com.example.demo.common.RedisKeys;
import com.example.demo.commonutils.KafkaSender;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/web")
public class HttpClientController {

	@Autowired
	private StringRedisTemplate  stringRedisTemplate;
    @Autowired
	private KafkaSender kafkaSender;

	@RequestMapping(value = "/html")
	public void httpClientRequest() {

		System.out.println("html  路径");
	}

	@RequestMapping(value = "" , method = RequestMethod.GET)
	public String httpClientRequest2(String name) {

		Long redisid = stringRedisTemplate.opsForList().leftPush(RedisKeys.CT_KEY,name);
		System.out.println(redisid);
		kafkaSender.send(name);

		System.out.println(" "+" get 路径");
		return  name;
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public void httpClientRequest3() {
//		String redisString = stringRedisTemplate.opsForValue().get(RedisKeys.CT_KEY);
		String redisString = stringRedisTemplate.opsForList().rightPop(RedisKeys.CT_KEY);
		System.out.println(redisString);
		System.out.println(" "+""+"   post 路径");
	}

	@RequestMapping(value = "/result" , method = RequestMethod.GET)
	public void httpClientRequest4(String name) {

		Long redisid = stringRedisTemplate.opsForList().leftPush(RedisKeys.CT_KEY,name);
		System.out.println(redisid);
		System.out.println(" "+" get 路径");
	}

}
