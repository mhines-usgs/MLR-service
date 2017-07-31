package gov.usgs.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geometry", propOrder
	= {"type"
	})

@XmlRootElement(name = "Geometry")
//@ApiModel(description = "GeoJSon geometry")
public class Geometry {

	@XmlType(name = "TypeEnum")
	@XmlEnum(String.class)
	public enum TypeEnum {

		@XmlEnumValue("Point")
		POINT(String.valueOf("Point"));

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
//	@ApiModelProperty(required = true, value = "the geometry type")
	private TypeEnum type = null;

	/**
	 * the geometry type
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Geometry {\n");

		sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
