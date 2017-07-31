package gov.usgs.wma.webservice;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.webservice.error.GenericExceptionMapper;


/**
 * Primary entry point to our webservices. (Stanadard Jersey
 * JAX-RS application).
 *
 * Wire up all configuration classes. Includes webservice, format, and error
 * handling provides.
 *
 * @author thongsav-usgs
 */
@ApplicationPath("/")
public class MlrWebservicesEntryPoint extends Application {
	private static final Logger log = LoggerFactory.getLogger(MlrWebservicesEntryPoint.class);

	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		
		// webservices
		classes.add(MlrWebservice.class);

		// features

		// Add additional features such as support for Multipart.
		classes.add(MultiPartFeature.class);

		// error handling providers
		classes.add(GenericExceptionMapper.class);
		
		
		log.trace("AqcuFrontEndWebservicesEntryPoint application started");
		return classes;
	}
}
