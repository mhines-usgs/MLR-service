package gov.usgs.wma.messaging;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.cida.microservices.messaging.MicroserviceMsgservice;

/**
 * Sends completed data retrieval request data back to the message service
 * 
 * @author thongsav
 */
public class CompleteSender {
	private static final Logger log = LoggerFactory.getLogger(CompleteSender.class);
	
	public static void sendRetrievalComplete(String requestId, String serviceRequestId, byte[] data, MicroserviceMsgservice msgService, String eventName) {
		Map<String, Object> headers = new HashMap<>();
		headers.put("eventType", eventName);
		
		log.debug("Data successfully retrieved for {}/{}, sending data as message", requestId, serviceRequestId);
		msgService.sendMessage(requestId, serviceRequestId, headers, data);
	}
}
