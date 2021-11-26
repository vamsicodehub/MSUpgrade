package com.aurionpro.generic.cache;

import java.net.URISyntaxException;
import java.util.Date;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DefaultDistributedCache {

	private static DistributableCache defaultDistributedCache ;

	public DefaultDistributedCache(){}


	public static DistributableCache getInstance() {
		/*if(ApplicationContext.getInstance().getProperty("cache.type") != null 
				&&  "Redis".equalsIgnoreCase(ApplicationContext.getInstance().getProperty("cache.type"))) {*/
			
		defaultDistributedCache = new RedisCache().getInstance();
		
		/*}else {
			defaultDistributedCache = new JCSCache().getInstance();
		}*/
		return defaultDistributedCache;
	}


	 public static void main(String[] args) throws URISyntaxException, Exception {
	  /*    ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(
	              SpringRedisConfig.class);*/
		 ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("redis-beans.xml");
	      try {           
	    	  /* new RedisCache().getInstance();
	    	  
	          String emp1Key = "emp:1";
	          String emp2Key = "emp:2";
	           
	          Map<String, String> emp1Map = new HashMap<>();
	          emp1Map.put("name", "Rohit");
	          emp1Map.put("dept", "Banking");
	          emp1Map.put("id", "3222");
	           
	          Map<String, String> emp2Map = new HashMap<>();
	          emp2Map.put("name", "Ram");
	          emp2Map.put("dept", "HR");
	          emp2Map.put("id", "02");
	           
	          //hashOperations.putAll(emp1Key, emp1Map);
	          //hashOperations.putAll(emp2Key, emp2Map);    
	          defaultDistributedCache.put(emp1Key, emp1Map);
	          defaultDistributedCache.put(emp2Key, emp2Map);

	          System.out.println("Get emp 1 details: " + defaultDistributedCache.getValue(emp1Key));
	          System.out.println("Get emp 2 details: " + defaultDistributedCache.getValue(emp2Key));
	          
	          List myList = new ArrayList();
	          myList.add("Redis");
	          myList.add("List");
	          myList.add("Object");
	          myList.add("Example");
	*/
	         /* FieldNameUtil.setObjectFromCache("MYCHACHE", "ID", Boolean.FALSE);
	          System.out.println("Get MYCHACHE: "+ FieldNameUtil.getObjectFromCache("MYCHACHE", "ID"));

	          List myList = new ArrayList();
	          myList.add("Redis");
	          myList.add("List");
	          myList.add("Object");
	          myList.add("Example");
	          FieldNameUtil.setObjectFromCache("MYLIST", "ID", myList);

	         System.out.println("Get MyList1: " + FieldNameUtil.getObjectFromCache("MYLIST", "ID"));*/
	    	/*  Date applicationDate = DateUtils.toDate("2020-08-02", "yyyy-MM-dd");
	    	  String key = "A";
	    	  DefaultDistributedCache.getInstance().putAppDate(key,applicationDate);*/
	    	  Date applicationDate = DefaultDistributedCache.getInstance().getAppDate("A");
	    	  System.out.println("applicationDate"+applicationDate);
	          
	      } finally {
	          ctx.close();
	      }
	  }

}
