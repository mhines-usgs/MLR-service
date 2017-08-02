package gov.usgs.wma.webservice;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.messaging.MsgserviceListener;
import gov.usgs.wma.util.ConfigurationLoaderSingleton;

public class MlrApplication {
	private static final Logger log = LoggerFactory.getLogger(MlrApplication.class);
			
	private static final String MLR_PORT_PROP_NAME = "mlr.service.port";
	
	public static void main(String[] args) throws Exception {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		
		context.addEventListener(new MsgserviceListener()); //Attaches MQ listeners

		int port = 8080;
		try {
			port = Integer.parseInt(ConfigurationLoaderSingleton.getProperty(MLR_PORT_PROP_NAME));
		} catch(Exception e) {
			log.info("Using default port {}, to configure set jvm/env/jndi property \"{}\"", port, MLR_PORT_PROP_NAME);
		}
		
		Server jettyServer = new Server(port);
		jettyServer.setHandler(context);

		ServletHolder jerseyServlet = context.addServlet(
				org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		
		jerseyServlet.setInitOrder(0);

		// Tells the Jersey Servlet which REST Appservice/class to load.
		jerseyServlet.setInitParameter(
				"javax.ws.rs.Application",
				MlrWebservicesEntryPoint.class.getCanonicalName());

		try {
			jettyServer.start();
			jettyServer.join();
		} finally {
			jettyServer.destroy();
		}
	}
}
