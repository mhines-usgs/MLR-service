package gov.usgs.wma.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Point", propOrder
	= {"coordinates"
	})

/**
 * GeoJson geometry
 */
public class Point extends Geometry {

	@XmlElement(name = "coordinates")
	private Point3d coordinates = null;

	/**
	 * Get coordinates
	 *
	 * @return coordinates
	 */
	public Point3d getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Point3d coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Point {\n");
		sb.append("    ").append(toIndentedString(super.toString())).append("\n");
		sb.append("    coordinates: ").append(toIndentedString(coordinates)).append("\n");
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
