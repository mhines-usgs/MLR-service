package gov.usgs.wma.messaging;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * A cache that stores data locally for a short amount of time. Used to transfer data from asyncrounous message listener.
 * 
 * @author thongsav
 */
public class DataCacheSingleton {
	private static final Logger log = LoggerFactory.getLogger(DataCacheSingleton.class);
	
	private static final int DATA_TTL = 10000; //data only kept around for 10 seconds
	private static final Cache<String, Object> dataCache = 
			CacheBuilder.newBuilder().expireAfterWrite(DATA_TTL, TimeUnit.MILLISECONDS).build();

	/**
	 *
	 * @param requestId
	 * @return
	 */
	public synchronized static Object getData(
			final String requestId) {
		log.trace(String.format("Getting data for id %s", requestId));
		String cacheKey = requestId;
		Object result = (Object) dataCache.asMap().get(cacheKey);
		return result;
	}

	/**
	 *
	 * @param requestId
	 * @return
	 */
	public static boolean isRequestReady(final String requestId) {
		return dataCache.asMap().containsKey(requestId);
	}

	/**
	 *
	 * @param requestId
	 * @param data
	 */
	public static void storeData(final String requestId, Object data) {
		log.trace(String.format("Caching data at id %s", requestId));
		dataCache.asMap().put(requestId, data);
	}
	
	/**
	 *
	 * @param requestId
	 * @return
	 */
	public synchronized static String getString(
			final String requestId) {
		log.trace(String.format("Getting data for id %s", requestId));
		String cacheKey = requestId;
		String result = (String) dataCache.asMap().get(cacheKey);
		return result;
	}
	
	/**
	 *
	 * @param requestId
	 * @param data
	 */
	public static void storeString(final String requestId, String data) {
		log.trace(String.format("Caching data at id %s", requestId));
		dataCache.asMap().put(requestId, data);
	}
	
	/**
	 *
	 * @param requestId
	 */
	public static void removeItem(String requestId) {
		dataCache.asMap().remove(requestId);
	}
}
