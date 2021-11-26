/*package com.aurionpro.generic.cache;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

import redis.clients.jedis.JedisPoolConfig;
 
@Configuration
@PropertySource(name="redis", value="classpath:/redis.properties")
public class SpringRedisConfig {

	@Resource
    ConfigurableEnvironment environment;
	
	@Autowired
	@Resource(name = "redisTemplate")
    HashOperations<String, byte[], byte[]> hashOperations;
    
    private RedisTemplate redisTemplate;
	//private HashOperations hashOperations;

    
    HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();

	@Bean
    public PropertiesPropertySource propertySource() {
        return (PropertiesPropertySource) environment.getPropertySources().get("redis");
    }
	
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
         JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(sentinelConfiguration(), poolConfiguration());
         Object property = propertySource().getProperty("spring.redis.sentinel.password");
         jedisConnectionFactory.setPassword((String)property);
         return jedisConnectionFactory;
    }

    @Bean
    public RedisSentinelConfiguration sentinelConfiguration() {
        return new RedisSentinelConfiguration(propertySource());
    }

    @Bean
    public JedisPoolConfig poolConfiguration() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    RedisTemplate<Object, Object> redisTemplate() {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }
    
    public void put(String key, Object value) {
      Map<byte[], byte[]> mappedHash = mapper.toHash(value);
      hashOperations.putAll(key, mappedHash);
    }

    public Object get(String key) {
      Map<byte[], byte[]> loadedHash = hashOperations.entries("key");
      return (Object) mapper.fromHash(loadedHash);
    }
    

}*/