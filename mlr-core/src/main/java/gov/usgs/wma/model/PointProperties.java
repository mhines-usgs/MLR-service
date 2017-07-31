package gov.usgs.wma.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PointProperties", propOrder
	= {"horizontalAccuracyCode", "horizontalDatum", "horizontalMethodCode", "altitudeAccuracy", "altitudeDatum", "altitudeMethodCode"
	})

@XmlRootElement(name = "PointProperties")
/**
 * The properties of a 3d point
 */
public class PointProperties {

	@XmlType(name = "HorizontalAccuracyCodeEnum")
	@XmlEnum(String.class)
	public enum HorizontalAccuracyCodeEnum {

		@XmlEnumValue("H") H(String.valueOf("H")), 
		@XmlEnumValue("1") _1(String.valueOf("1")), 
		@XmlEnumValue("5") _5(String.valueOf("5")), 
		@XmlEnumValue("S") S(String.valueOf("S")), 
		@XmlEnumValue("R") R(String.valueOf("R")), 
		@XmlEnumValue("F") F(String.valueOf("F")), 
		@XmlEnumValue("T") T(String.valueOf("T")), 
		@XmlEnumValue("M") M(String.valueOf("M")), 
		@XmlEnumValue("U") U(String.valueOf("U"));

		private String value;

		HorizontalAccuracyCodeEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static HorizontalAccuracyCodeEnum fromValue(String v) {
			for (HorizontalAccuracyCodeEnum b : HorizontalAccuracyCodeEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "horizontalAccuracyCode")
	//See Section 1.18 in GWSI 2 Section 1
	private HorizontalAccuracyCodeEnum horizontalAccuracyCode = null;

	@XmlType(name = "HorizontalDatumEnum")
	@XmlEnum(String.class)
	public enum HorizontalDatumEnum {

		@XmlEnumValue("urn:ogc:def:crs:OGC::CRS84")
		CRS84(String.valueOf("urn:ogc:def:crs:OGC::CRS84"));

		private String value;

		HorizontalDatumEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static HorizontalDatumEnum fromValue(String v) {
			for (HorizontalDatumEnum b : HorizontalDatumEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "horizontalDatum")
	private HorizontalDatumEnum horizontalDatum = null;

	@XmlType(name = "HorizontalMethodCodeEnum")
	@XmlEnum(String.class)
	public enum HorizontalMethodCodeEnum {

		@XmlEnumValue("C")
		C(String.valueOf("C")),
		@XmlEnumValue("D")
		D(String.valueOf("D")),
		@XmlEnumValue("G")
		G(String.valueOf("G")),
		@XmlEnumValue("L")
		L(String.valueOf("L")),
		@XmlEnumValue("M")
		M(String.valueOf("M")),
		@XmlEnumValue("N")
		N(String.valueOf("N")),
		@XmlEnumValue("R")
		R(String.valueOf("R")),
		@XmlEnumValue("S")
		S(String.valueOf("S")),
		@XmlEnumValue("U")
		U(String.valueOf("U"));

		private String value;

		HorizontalMethodCodeEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static HorizontalMethodCodeEnum fromValue(String v) {
			for (HorizontalMethodCodeEnum b : HorizontalMethodCodeEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "horizontalMethodCode")
	// See Section 1.19 in GWSI 2 Section 1
	private HorizontalMethodCodeEnum horizontalMethodCode = null;

	@XmlElement(name = "altitudeAccuracy")
	// Altitude accuracy in meters
	private Integer altitudeAccuracy = null;

	@XmlType(name = "AltitudeDatumEnum")
	@XmlEnum(String.class)
	public enum AltitudeDatumEnum {

		@XmlEnumValue("NGVD29")
		NGVD29(String.valueOf("NGVD29")),
		@XmlEnumValue("NAVD88")
		NAVD88(String.valueOf("NAVD88"));

		private String value;

		AltitudeDatumEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static AltitudeDatumEnum fromValue(String v) {
			for (AltitudeDatumEnum b : AltitudeDatumEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "altitudeDatum")
	private AltitudeDatumEnum altitudeDatum = null;

	@XmlType(name = "AltitudeMethodCodeEnum")
	@XmlEnum(String.class)
	public enum AltitudeMethodCodeEnum {

		@XmlEnumValue("A")
		A(String.valueOf("A")),
		@XmlEnumValue("D")
		D(String.valueOf("D")),
		@XmlEnumValue("G")
		G(String.valueOf("G")),
		@XmlEnumValue("L")
		L(String.valueOf("L")),
		@XmlEnumValue("M")
		M(String.valueOf("M")),
		@XmlEnumValue("N")
		N(String.valueOf("N")),
		@XmlEnumValue("R")
		R(String.valueOf("R")),
		@XmlEnumValue("U")
		U(String.valueOf("U"));

		private String value;

		AltitudeMethodCodeEnum(String v) {
			value = v;
		}

		public String value() {
			return value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}

		public static AltitudeMethodCodeEnum fromValue(String v) {
			for (AltitudeMethodCodeEnum b : AltitudeMethodCodeEnum.values()) {
				if (String.valueOf(b.value).equals(v)) {
					return b;
				}
			}
			return null;
		}
	}

	@XmlElement(name = "altitudeMethodCode")
	private AltitudeMethodCodeEnum altitudeMethodCode = null;

	/**
	 * see Section 1.18 in GWSI 2 Section 1
	 *
	 * @return horizontalAccuracyCode
	 *
	 */
	public HorizontalAccuracyCodeEnum getHorizontalAccuracyCode() {
		return horizontalAccuracyCode;
	}

	public void setHorizontalAccuracyCode(HorizontalAccuracyCodeEnum horizontalAccuracyCode) {
		this.horizontalAccuracyCode = horizontalAccuracyCode;
	}

	/**
	 * Get horizontalDatum
	 *
	 * @return horizontalDatum
	 *
	 */
	public HorizontalDatumEnum getHorizontalDatum() {
		return horizontalDatum;
	}

	public void setHorizontalDatum(HorizontalDatumEnum horizontalDatum) {
		this.horizontalDatum = horizontalDatum;
	}

	/**
	 * see Section 1.19 in GWSI 2 Section 1
	 *
	 * @return horizontalMethodCode
	 *
	 */
	public HorizontalMethodCodeEnum getHorizontalMethodCode() {
		return horizontalMethodCode;
	}

	public void setHorizontalMethodCode(HorizontalMethodCodeEnum horizontalMethodCode) {
		this.horizontalMethodCode = horizontalMethodCode;
	}

	/**
	 * Altitude accuracy in meters
	 *
	 * @return altitudeAccuracy
	 *
	 */
	public Integer getAltitudeAccuracy() {
		return altitudeAccuracy;
	}

	public void setAltitudeAccuracy(Integer altitudeAccuracy) {
		this.altitudeAccuracy = altitudeAccuracy;
	}

	/**
	 * Get altitudeDatum
	 *
	 * @return altitudeDatum
	 *
	 */
	public AltitudeDatumEnum getAltitudeDatum() {
		return altitudeDatum;
	}

	public void setAltitudeDatum(AltitudeDatumEnum altitudeDatum) {
		this.altitudeDatum = altitudeDatum;
	}

	/**
	 * Get altitudeMethodCode
	 *
	 * @return altitudeMethodCode
	 *
	 */
	public AltitudeMethodCodeEnum getAltitudeMethodCode() {
		return altitudeMethodCode;
	}

	public void setAltitudeMethodCode(AltitudeMethodCodeEnum altitudeMethodCode) {
		this.altitudeMethodCode = altitudeMethodCode;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class PointProperties {\n");

		sb.append("    horizontalAccuracyCode: ").append(toIndentedString(horizontalAccuracyCode)).append("\n");
		sb.append("    horizontalDatum: ").append(toIndentedString(horizontalDatum)).append("\n");
		sb.append("    horizontalMethodCode: ").append(toIndentedString(horizontalMethodCode)).append("\n");
		sb.append("    altitudeAccuracy: ").append(toIndentedString(altitudeAccuracy)).append("\n");
		sb.append("    altitudeDatum: ").append(toIndentedString(altitudeDatum)).append("\n");
		sb.append("    altitudeMethodCode: ").append(toIndentedString(altitudeMethodCode)).append("\n");
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
