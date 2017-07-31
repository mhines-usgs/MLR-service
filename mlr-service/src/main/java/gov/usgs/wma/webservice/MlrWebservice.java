package gov.usgs.wma.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is used as the front end to the reporting system and will be imported into
 * other jersey applications to enable reporting. Think of this as an "API middleware" class. 
 * 
 * @author thongsav
 */
@Path("/")
public class MlrWebservice {
	private static final Logger log = LoggerFactory.getLogger(MlrWebservice.class);
	
	/**
	 * Default Constructor
	 */
	public MlrWebservice() {
	}
	
	/**
	 * Generates a report using the specified parameters and report type and returns
	 * the rendered HTML page.
	 * 
	 * @param req The raw HTTP request received from the UI
	 * @param reportType The type of report to generate
	 * @return The rendered HTML page representing the report
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON+";qs=1.0")
	@Path("monitoringLocation/{locationNumber}")
	public String getReportHtml(@Context final HttpServletRequest req, @PathParam("locationNumber") final String locationNumber) {
		//TODO Call java core service
		return "{ \"response\": \"CHANGE THIS TO MONITORING LOCATION\" }";
	}
}
