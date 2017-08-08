package gov.usgs.wma.webservice.error;

import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * A generic error web response to send to the UI when an error occurs and no
 * specific error response exists for the type of error received.
 * 
 * @author thongsav
 */
@XmlType(propOrder = {"status", "code", "message", "serviceId"})
@XmlRootElement(name = "error")
public class GenericErrorResponse {

	private String message;

	private Response.Status status;
	
	private Integer code;

	private String serviceId;

	/**
	 *
	 * @return
	 */
	@XmlElement(name = "serviceId")
	public String getServiceId() {
		return serviceId;
	}

	/**
	 *
	 * @param serviceId
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 *
	 * @return
	 */
	@XmlElement(name = "message")
	public String getMessage() {
		return message;
	}

	/**
	 *
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 *
	 * @return
	 */
	@XmlElement(name = "status")
	public Response.Status getStatus() {
		return status;
	}
	
	@XmlElement(name = "code")
	public Integer getCode() {
		return code;
	}

	/**
	 *
	 * @param status
	 */
	public void setStatus(Response.Status status) {
		this.status = status;
		this.code = status.getStatusCode();
	}
}
