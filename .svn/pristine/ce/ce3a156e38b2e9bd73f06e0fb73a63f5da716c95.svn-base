package com.aurionpro.generic.cache;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.aurionpro.cashpro.commons.utils.CacheDetails;


public interface DistributableCache {
	
	void put(String pKey,  Map<String,CacheDetails> pValue);
	 Map<String,CacheDetails> get(String pKey);
	 Set<String> keySet();
	 Object getCache ();
	 void put(String key, Object value);
	 Object getValue(String key);
	 void putLoginTicket(String key, Object value);
	 Object getLoginTicket(String key);
	 void removeLoginTicket(String key);
	 void resetCacheForCharges() ;
	 void clearObjFromCacheStartsWithKey(String serviceNameKey);
	 void removeObjFromCacheStartsWithKey(String serviceNameKey);
	// Added By Pravin D. to Sync. the date on cluster
	void putAppDate(String pKey, Date pValue);
	Date getAppDate(String pKey);
	void removeFromCache(String cacheKeyName,String id) ;
}  
