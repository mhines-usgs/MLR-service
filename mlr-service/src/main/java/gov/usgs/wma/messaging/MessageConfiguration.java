package gov.usgs.wma.messaging;

import gov.usgs.wma.util.ConfigurationLoaderSingleton;

public class MessageConfiguration {
	public static final String MESSAGING_EXCHANGE_NAME = "amq.topic";
	
	public static final String MLR_SERVICE_NAME = "mlr-service";
	
	/**
	 * Tag for this service. Will only answer requests for this tag
	 */
	public static final String MLR_SERVICE_TAG; 
	static {
		String serviceTag = ConfigurationLoaderSingleton.getProperty("mlr.service.tag");
		if(serviceTag == null || serviceTag.isEmpty()) {
			serviceTag = "LATEST";
		}
		MLR_SERVICE_TAG = serviceTag;
	}
	
	public static final String GET_REQUEST_TOPIC = MLR_SERVICE_NAME + "-get";
	public static final String GET_READY_TOPIC = GET_REQUEST_TOPIC + "-ready";

	public static final String UPDATE_REQUEST_TOPIC = MLR_SERVICE_NAME + "-update";
	public static final String UPDATE_READY_TOPIC = UPDATE_REQUEST_TOPIC + "-ready";

	public static final String CREATE_REQUEST_TOPIC = MLR_SERVICE_NAME + "-create";
	public static final String CREATE_READY_TOPIC = CREATE_REQUEST_TOPIC + "-ready";

	public static final String LIST_REQUEST_TOPIC = MLR_SERVICE_NAME + "-list";
	public static final String LIST_READY_TOPIC = LIST_REQUEST_TOPIC + "-ready";
}
