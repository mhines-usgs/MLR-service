package gov.usgs.wma.messaging;

import gov.usgs.cida.microservices.api.messaging.MicroserviceHandler;
import gov.usgs.cida.microservices.messaging.MicroserviceMsgservice;
import gov.usgs.cida.microservices.util.MessageUtils;
import gov.usgs.wma.util.MlrGsonFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Handles to mlr service with the specified 
 * site number and page size.
 * 
 * @author thongsav 
 */
public class MlrGetRequestHandler implements MicroserviceHandler {
	private static final Logger log = LoggerFactory.getLogger(MlrGetRequestHandler.class);

	/**
	 * Handles the request to the getAvailableSites function in the data service
	 * 
	 * @param requestId The request ID to use for this process
	 * @param serviceRequestId The SRI to use for this process
	 * @param params Additional parameters to send to the service
	 * @param body The JSON data to send to the service
	 * @param msgService The microservices message service instance to interact with
	 * @throws IOException
	 */
	@Override
	public void handle(String requestId, String serviceRequestId, Map<String, Object> params, byte[] body, MicroserviceMsgservice msgService) throws IOException {
		String locationNumber = MessageUtils.getStringFromHeaders(params, "locationNumber");
		log.trace("Get request for location {}", locationNumber);
		
		//TODO call java service
		Map<String,String> result = new HashMap<>();
		result.put("mqResult", "MLR LOCATION OBJECT HERE");
		
		CompleteSender.sendRetrievalComplete(requestId, serviceRequestId, 
				MlrGsonFactory.getConfiguredGson().toJson(result).getBytes(),
				msgService,
				MessageConfiguration.GET_READY_TOPIC
				);
	}

	/**
	 * Gets the bindings that this handler is setup to respond to
	 * 
	 * @param serviceName The service name to get bindings for
	 * @return The map of bindings that this handler responds to
	 */
	@Override
	public Iterable<Map<String, Object>> getBindings(String serviceName) {
		LinkedList<Map<String,Object>> result = new LinkedList<>();
		
		Map<String, Object> requestBindingArgs = new HashMap<>();
		requestBindingArgs.put("x-match", "all");
		requestBindingArgs.put("eventType", MessageConfiguration.GET_REQUEST_TOPIC);
		requestBindingArgs.put("serviceTag", MessageConfiguration.DATA_RETRIEVAL_SERVICE_TAG);
		requestBindingArgs.put("serviceName", serviceName);
		result.add(requestBindingArgs);
		
		return result;
	}
}
