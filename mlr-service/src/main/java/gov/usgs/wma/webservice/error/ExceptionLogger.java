package gov.usgs.wma.webservice.error;

import javax.ws.rs.core.Response;

import org.slf4j.*;

/**
 * Static utility class to help the logging and reporting of errors.
 *
 * @author thongsav
 */
public class ExceptionLogger {

	private static final Logger LOG = LoggerFactory.getLogger(ExceptionLogger.class);

	/**
	 * Function which creates and returns errors. Will also print the
	 * stack trace with a service ID (currentTimeMillis) logged into the system
	 * logs
	 *
	 * @param e The raw throwable exception
	 * @param message the message to report out
	 * @param code the http code to set the mime type to
	 * @return GenericErrorResponse populated with message, code, and a service ID
	 */
	public static GenericErrorResponse getAndLogError(Throwable e, String message, Response.Status code) {
		String serviceId = String.valueOf(System.currentTimeMillis());

		GenericErrorResponse error = new GenericErrorResponse();
		error.setMessage(message);
		error.setStatus(code);
		error.setServiceId(serviceId);

		//Log this error with service id
		LOG.error("MLR Service error #" + serviceId + ": " + e.getMessage(), e);

		return error;
	}
}
