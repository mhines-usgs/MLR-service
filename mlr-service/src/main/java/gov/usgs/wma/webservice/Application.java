package gov.usgs.wma.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PreDestroy;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import gov.usgs.cida.microservices.api.messaging.MicroserviceHandler;
import gov.usgs.wma.messaging.MessageConfiguration;
import gov.usgs.wma.messaging.MicroserviceUtils;
import gov.usgs.wma.messaging.MlrCreateRequestHandler;
import gov.usgs.wma.messaging.MlrGetRequestHandler;
import gov.usgs.wma.messaging.MlrListRequestHandler;
import gov.usgs.wma.messaging.MlrUpdateRequestHandler;

@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
        	.run(args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
	    // our rest resources will be available in the path /rest/*
	    registration.addInitParameter("javax.ws.rs.Application", MlrWebservicesEntryPoint.class.getCanonicalName());
	    
	    return registration;
	} 
	
	@Bean
	public ServletContextInitializer mqContextInitializer() {
		ServletContextInitializer mqContext = new ServletContextInitializer() {
			@Override
			public void onStartup(ServletContext servletContext) throws ServletException {
				Set<Class<? extends MicroserviceHandler>> handlers = new HashSet<>();
				
				handlers.add(MlrGetRequestHandler.class);
				handlers.add(MlrCreateRequestHandler.class);
				handlers.add(MlrUpdateRequestHandler.class);
				handlers.add(MlrListRequestHandler.class);
				
				log.info("MLR MQ service initiatalizing with service tag {}", MessageConfiguration.MLR_SERVICE_TAG);
				
				try {
					MicroserviceUtils.initService(MessageConfiguration.MLR_SERVICE_NAME, handlers);
				} catch (Exception e) {
					log.warn("Failed to initialize MQ listeners", e);
				}
			}
		};
		
		return mqContext;
	}
	
	@PreDestroy
	public void shutDownMqConnections() {
		log.info("Shutting down MLR MQ Service");
		MicroserviceUtils.quietCloseService(MessageConfiguration.MLR_SERVICE_NAME);
	}
}