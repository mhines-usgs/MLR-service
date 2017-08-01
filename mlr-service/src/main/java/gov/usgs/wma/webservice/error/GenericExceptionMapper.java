package gov.usgs.wma.webservice.error;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Catch-all exception handler/reporter. This mapper is configured last and will
 * catch any/all exceptions that aren't caught by another mapper.
 *
 * @author thongsav
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	public Response toResponse(Throwable ex) {
		Response.Status code = Response.Status.INTERNAL_SERVER_ERROR;
		GenericErrorResponse error = ExceptionLogger.getAndLogError(ex,
				ex.getMessage(), code);
		return Response.status(code).entity(error).type("application/xml").build();
	}
}
