package co.ufps.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration	
public class AppConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedis = new JedisConnectionFactory();
		jedis.setPort(6379);
		jedis.setHostName("127.0.0.1");
		return jedis;
		// template.setKeySerializer(new StringRedisSerializer());
		// template.setConnectionFactory(jedis);
	}

	@Bean
	public RedisTemplate<String, String> getTemplate() {
		RedisTemplate<String, String> template = new RedisTemplate<>();
		template.setConnectionFactory(jedisConnectionFactory());
		System.out.println("Prendio redis");
		return template;
	}

	
	
	

}
