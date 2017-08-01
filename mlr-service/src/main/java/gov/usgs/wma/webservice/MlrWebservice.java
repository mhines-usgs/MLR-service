package gov.usgs.wma.webservice;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
	 * retrieves a specific location
	 * 
	 * @param req The raw HTTP request received from the UI
	 * @param locationNumber location number for data to retrieve
	 * @return a location
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("monitoringLocation/{locationNumber}")
	public String getMonitoringLocation(@Context final HttpServletRequest req, @PathParam("locationNumber") final String locationNumber) {
		//TODO Call java core service
		return "{ \"locationResponse\": \"CHANGE THIS TO MONITORING LOCATION\" }";
	}
	
	/**
	 * Attempts to create a location from the provided json. Returns the newly created site with IDs populated
	 * 
	 * @param newLocationJson json representing site to create
	 * @return The rendered HTML page representing the report
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("monitoringLocations")
	public String createMonitoringLocation(final String newLocationJson) {
		//TODO Call java core service
		return "{ \"createResponse\": \"CHANGE THIS TO MONITORING LOCATION\" }";
	}
	
	/**
	 * Attempts to update a location from the provided json. Returns the newly created site with IDs populated
	 * 
	 * @param newLocationJson json representing site to update
	 * @return The rendered HTML page representing the report
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("monitoringLocation/{locationNumber}")
	public String updateMonitoringLocation(@Context final HttpServletRequest req, @PathParam("locationNumber") final String locationNumber, final String newLocationJson) {
		//TODO Call java core service
		return "{ \"updateResponse\": \"CHANGE THIS TO MONITORING LOCATION\" }";
	}
	
	/**
	 * retrieves list of locations
	 * 
	 * @param query query to restrict locations
	 * @return a location
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("monitoringLocations")
	public String getLocations(@QueryParam("query") final String query) {
		//TODO Call java core service
		return "[{ \"listResponse\": \"CHANGE THIS TO MONITORING LOCATION\" }]";
	}
}
