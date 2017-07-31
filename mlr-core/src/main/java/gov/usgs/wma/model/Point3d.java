package gov.usgs.wma.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "Point3d")

/**
 * An array that follows the order of [longitude, latitude, elevation]"
 */
public class Point3d extends ArrayList<BigDecimal> {

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Point3d {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
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
