package gov.usgs.wma.messaging;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.cida.microservices.messaging.MicroserviceMsgservice;

/**
 * Sends completed data retrieval request data back to the message service
 * 
 * @author dmsibley
 */
public class CompleteSender {
	private static final Logger log = LoggerFactory.getLogger(CompleteSender.class);
	
	public static void sendRetrievalComplete(String requestId, String serviceRequestId, byte[] data, MicroserviceMsgservice msgService, String eventName, String clientId) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("serviceName", msgService.getServiceName());
		headers.put("eventType", eventName);
		headers.put("clientId", clientId);
		
		log.debug("Data successfully retrieved for {}/{}, sending data as message", requestId, serviceRequestId);
		msgService.sendMessage(requestId, serviceRequestId, headers, data);
	}
}
