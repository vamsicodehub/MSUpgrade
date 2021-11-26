package com.aurionpro.generic.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;

import com.aurionpro.cashpro.commons.utils.CacheDetails;

public class RedisCache implements DistributableCache{

	private static DistributableCache defaultDistributedCache;
	private static RedisTemplate redisTemplate;
	private static HashOperations hashOperations;
	private static ListOperations listOperations;
	private static SetOperations setOperations;

	public RedisCache(){}

	private static void initializedCache(){
		
		/*ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(
                SpringRedisConfig.class);*/
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("redis-beans.xml");
		redisTemplate = (RedisTemplate) ctx.getBean("stringRedisTemplate");
		hashOperations = redisTemplate.opsForHash();
		listOperations = redisTemplate.opsForList();
		setOperations = redisTemplate.opsForSet();
		//Code for Redis Cache initialization
		
		defaultDistributedCache = new RedisCache();
         
	}

	public static DistributableCache getInstance() {
		if(defaultDistributedCache==null){	

			synchronized (RedisCache.class) {
				if(defaultDistributedCache==null){
					initializedCache();
				}
			}
		}
		return defaultDistributedCache;
	}

	
	public Set<String> keySet() {
		
		return  hashOperations.keys("*");
	}

	public void putAppDate(String pKey, Date pValue) {

		put(pKey, pValue);
	
	}

	public Date getAppDate(String pKey) {
		
		 return (Date)getValue(pKey);
	}


	public void removeFromCache(String cacheKeyName,String id) {
		try {
			if(hashOperations!=null) {
				
				System.out.println("removeFromCache ---");
				
				Map<String, CacheDetails> map = (Map<String, CacheDetails>) get(cacheKeyName) ;
				if(map != null){
					map.remove(id);
					if(map.keySet()!=null && map.keySet().size()>0) {
						put(cacheKeyName, map);	
					} else {
						hashOperations.delete(cacheKeyName);
					}

				}
			}
		} catch(Exception e) {
			e.printStackTrace(); 
		}
	}


	public void putLoginTicket(String pKey, Object pValue) {

			put(pKey, pValue);
	}

	public Object getLoginTicket(String pKey) {

		
		return getValue(pKey);
	}

	public void removeLoginTicket(String pKey) {

		try {
			hashOperations.delete(pKey);
			System.out.println("removeLoginTicket ---");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public HashOperations getCache () {
		return hashOperations;
	}

public void put(String key, Object value) {
	HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();
    Map<byte[], byte[]> mappedHash = mapper.toHash(value);
    hashOperations.putAll(key, mappedHash);
  }


public void put(String pKey,  Map<String,CacheDetails> pValue) {
	try {
	    hashOperations.putAll(pKey, pValue);
	} catch (Exception e) {
		e.printStackTrace();
	}
}


  @SuppressWarnings("unchecked")
public Object getValue(String key) {

	  HashMapper<Object, byte[], byte[]> mapper = new ObjectHashMapper();
	  Map<byte[], byte[]> mappedHash =  hashOperations.entries(key);
	  Object fromHash = mapper.fromHash(mappedHash);
	  return fromHash ;
	  
  }
  
  
  public  Map<String,CacheDetails> get(String pKey) {
	    return (Map<String, CacheDetails>) hashOperations.entries(pKey);

	}
  
  
  public void removeObjFromCacheStartsWithKey(String serviceNameKey) {
		if (serviceNameKey == null || serviceNameKey.equals(""))
			return;

		Set<String> cacheKeySet = hashOperations.keys(serviceNameKey+"*");

		for (String key : cacheKeySet) {
			if (key != null && key.startsWith(serviceNameKey)) {
				// remove key from cache
				// cache.put(key, null);
				hashOperations.delete(key);
			}
		}
	}

	public void clearObjFromCacheStartsWithKey(String serviceNameKey) {
		if (serviceNameKey == null || serviceNameKey.equals(""))
			return;

		DistributableCache cache = DefaultDistributedCache.getInstance();
		Set<String> cacheKeySet =hashOperations.keys(serviceNameKey+"*");;

		for (String key : cacheKeySet) {
			if (key != null && key.startsWith(serviceNameKey)) {
				// remove key from cache
				// cache.put(key, null);
				hashOperations.delete(key);
			}
		}
	}
	
	public void resetCacheForCharges() {

		DistributableCache cache = DefaultDistributedCache.getInstance();
		Set<String> cacheEntries = cache.keySet();
			for (String s : cacheEntries) {
			Map<String, CacheDetails> map = cache.get(s);
			Set<String> keys = map.keySet();
			Map<String, CacheDetails> expired = new HashMap<String, CacheDetails>();
			for (String key : keys) {

				if (key.contains("chargeMappingType")) {
					CacheDetails cacheDetails = map.get(key);
					if (cacheDetails.expiryTime.compareTo(new Date()) <= 0) {
						expired.put(key, cacheDetails);
					}
				}
			}
			Set<String> expiredKeys = expired.keySet();
			for (String key : expiredKeys) {
				synchronized (map) {
					map.remove(key);
				}
			}
		}

	}

  
}
