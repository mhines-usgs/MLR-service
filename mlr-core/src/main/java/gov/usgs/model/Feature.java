package gov.usgs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Feature", propOrder
	= {"type", "geometry", "pointProperties"
	})

@XmlRootElement(name = "Feature")
public class Feature {

	@XmlType(name = "TypeEnum")
	@XmlEnum(String.class)
	public enum TypeEnum {

		@XmlEnumValue("Feature")
		FEATURE(String.valueOf("Feature"));

		private String value;

		TypeEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static TypeEnum fromValue(String v) {
			for (TypeEnum b : TypeEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "type")
	private TypeEnum type = null;

	@XmlElement(name = "geometry")
	private Point geometry = null;

	@XmlElement(name = "pointProperties")
	private PointProperties pointProperties = null;

	/**
	 * Get type
	 *
	 * @return type
  *
	 */
	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	/**
	 * Get geometry
	 *
	 * @return geometry
  *
	 */
	public Point getGeometry() {
		return geometry;
	}

	public void setGeometry(Point geometry) {
		this.geometry = geometry;
	}

	/**
	 * Get pointProperties
	 *
	 * @return pointProperties
  *
	 */
	public PointProperties getPointProperties() {
		return pointProperties;
	}

	public void setPointProperties(PointProperties pointProperties) {
		this.pointProperties = pointProperties;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Feature {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
		sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
		sb.append("    pointProperties: ").append(toIndentedString(pointProperties)).append("\n");
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
