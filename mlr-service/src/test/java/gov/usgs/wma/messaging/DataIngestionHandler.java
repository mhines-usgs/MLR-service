package gov.usgs.wma.messaging;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import gov.usgs.cida.microservices.api.messaging.MicroserviceHandler;
import gov.usgs.cida.microservices.messaging.MicroserviceMsgservice;

public class DataIngestionHandler implements MicroserviceHandler {
	@Override
	public void handle(String requestId, String serviceRequestId, Map<String, Object> params, byte[] body, MicroserviceMsgservice msgService) throws IOException {
		DataCacheSingleton.storeData(requestId, new String(body));
	}

	/**
	 * Returns the messages that this service should listen for and be bound to
	 * 
	 * @param serviceName The service name to bind
	 * @return The list of bound service messages
	 */
	@Override
	public Iterable<Map<String, Object>> getBindings(String serviceName) {
		LinkedList<Map<String,Object>> result = new LinkedList<>();
		
		Map<String, Object> listenBindingArgs = new HashMap<>();
		listenBindingArgs.put("x-match", "all");
		listenBindingArgs.put("eventType", MessageConfiguration.GET_READY_TOPIC);
		
		result.add(listenBindingArgs);
		
		return result;
	}
}