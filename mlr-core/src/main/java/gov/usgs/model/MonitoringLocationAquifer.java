package gov.usgs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NewMonitoringLocationAquifer", propOrder
	= {"id", "code", "name", "nationalAquifer"
	})

@XmlRootElement(name = "NewMonitoringLocationAquifer")
public class MonitoringLocationAquifer {

	@XmlElement(name = "id")
	private Long id = null;

	@XmlElement(name = "code")
	private String code = null;

	@XmlElement(name = "name")
	private String name = null;

	@XmlElement(name = "nationalAquifer")
	private MonitoringLocationAquifer nationalAquifer = null;

	/**
	 * Get id
	 *
	 * @return id
	 *
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get code
	 *
	 * @return code
	 *
	 */
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Get name
	 *
	 * @return name
	 *
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get nationalAquifer
	 *
	 * @return nationalAquifer
	 *
	 */
	public MonitoringLocationAquifer getNationalAquifer() {
		return nationalAquifer;
	}

	public void setNationalAquifer(MonitoringLocationAquifer nationalAquifer) {
		this.nationalAquifer = nationalAquifer;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class NewMonitoringLocationAquifer {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    code: ").append(toIndentedString(code)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    nationalAquifer: ").append(toIndentedString(nationalAquifer)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4
	 * spaces (except the first line).
	 */
	private static String toIndentedString(Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
