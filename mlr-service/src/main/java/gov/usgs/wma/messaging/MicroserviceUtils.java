package gov.usgs.wma.messaging;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.cida.microservices.api.messaging.MicroserviceHandler;
import gov.usgs.cida.microservices.api.messaging.exception.MqConnectionException;
import gov.usgs.cida.microservices.messaging.MicroserviceMsgservice;
import gov.usgs.cida.microservices.messaging.MicroserviceMsgserviceFactory;
import gov.usgs.wma.util.ConfigurationLoaderSingleton;

/**
 * Utility class that wraps and aids with basic microservice architecture
 * management and configuration.
 * 
 * @author thongsav
 */
public class MicroserviceUtils {
	private static final Logger log = LoggerFactory.getLogger(MicroserviceUtils.class);
	
	private static final String DATA_QUEUE_TIME_JNDI_NAME = "aqcu.mailbox.ttl.ms";

	private static final int EXPIRE_DATA_QUEUE_DEFAULT_TIME_MS = 300000; //5 minutes
	private static final Integer EXPIRE_DATA_QUEUE;
	static {
		String rawTimeout = ConfigurationLoaderSingleton.getProperty(DATA_QUEUE_TIME_JNDI_NAME);
		EXPIRE_DATA_QUEUE = rawTimeout != null ? Integer.valueOf(rawTimeout): EXPIRE_DATA_QUEUE_DEFAULT_TIME_MS;
	}
	
	/**
	 *
	 * @return How long MQ data survives before it expires and is deleted
	 */
	public static Integer getMqDataExpiry() {
		return EXPIRE_DATA_QUEUE;
	}
	
	/**
	 * Initializes a microservice with a supplied name and set of handlers
	 * 
	 * @param serviceName The name to use for the new service
	 * @param handlers The handlers to connect to the new service
	 * @throws MqConnectionException
	 */
	public static void initService(String serviceName, Set<Class<? extends MicroserviceHandler>> handlers) throws MqConnectionException {
		MicroserviceMsgserviceFactory.getInstance(serviceName).buildPersistentMicroserviceMsgservice(handlers, getMqDataExpiry());
		log.info("{} microservice initialized", serviceName);
	}
	
	/**
	 * Gets the MicroserviceMsgservice instance for a given service name
	 * @param serviceName The name to use for looking up and returning the correct message service
	 * @return The MicroserviceMsgservice associated with the supplied service name
	 */
	public static MicroserviceMsgservice getServiceInstance(String serviceName) {
		return MicroserviceMsgserviceFactory.getInstance(serviceName).getMicroserviceMsgservice();
	}
	
	/**
	 * Quietly closes the message service for a given service name but does not completely destroy the service
	 * 
	 * @param serviceName The service name to quietly close the messaging service for
	 */
	public static void quietCloseService(String serviceName) {
		try {
			MicroserviceMsgserviceFactory.getInstance(serviceName).getMicroserviceMsgservice().close();
		} catch (IOException e) {
			log.trace("Error quiet closing services", e);
		}
	}
	
	/**
	 * Initializes a mailbox with the given mailbox name
	 * 
	 * @param mailbox The name to use for the new mailbox
	 * @return The MicroserviceMsgservice associated with the new data mailbox
	 * @throws MqConnectionException
	 */
	public static MicroserviceMsgservice initMailbox(String mailbox) throws MqConnectionException {
		MicroserviceMsgservice msgInstance = new MicroserviceMsgserviceFactory(mailbox)
				.buildMicroserviceMsgservice(new HashSet<Class<? extends MicroserviceHandler>>(), getMqDataExpiry());
	
		msgInstance.declareQueueForType(
				mailbox, 
				"data-mailbox", 
				EXPIRE_DATA_QUEUE, EXPIRE_DATA_QUEUE);
		
		return msgInstance;
	}
}
