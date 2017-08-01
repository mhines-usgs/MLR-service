package gov.usgs.wma.messaging;

import gov.usgs.cida.microservices.api.messaging.MicroserviceHandler;
import gov.usgs.cida.microservices.api.messaging.exception.MqConnectionException;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creates and configures a message service listener for the data retrieval service
 * 
 * @author thongsav 
 */
@WebListener
public class MsgserviceListener implements ServletContextListener {
	private static final Logger log = LoggerFactory.getLogger(MsgserviceListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Set<Class<? extends MicroserviceHandler>> handlers = new HashSet<>();
		
		handlers.add(MlrGetRequestHandler.class);
		handlers.add(MlrCreateRequestHandler.class);
		handlers.add(MlrUpdateRequestHandler.class);
		handlers.add(MlrListRequestHandler.class);
		
		log.info("MLR service initiatalizing with service tag {}", MessageConfiguration.MLR_SERVICE_TAG);
		
		try {
			MicroserviceUtils.initService(MessageConfiguration.MLR_SERVICE_NAME, handlers);
		} catch (MqConnectionException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		MicroserviceUtils.quietCloseService(MessageConfiguration.MLR_SERVICE_NAME);
	}
}
