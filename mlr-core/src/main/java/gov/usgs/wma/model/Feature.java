package gov.usgs.wma.model;

import gov.usgs.wma.model.AltitudeDatum;
import gov.usgs.wma.model.AltitudeMethod;
import gov.usgs.wma.model.HorizontalAccuracy;
import gov.usgs.wma.model.HorizontalDatum;
import gov.usgs.wma.model.HorizontalMethod;
import gov.usgs.wma.model.Point;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "Feature", propOrder =
    { "geometry", "horizontalAccuracy", "horizontalDatum", "horizontalMethod", "altitudeAccuracy", "altitudeDatum", "altitudeMethodCode"
})

@XmlRootElement(name="Feature")
public class Feature  {
	
  @XmlElement(name="geometry")
  private Point geometry = null;

  @XmlElement(name="horizontalAccuracy")
  private HorizontalAccuracy horizontalAccuracy = null;

  @XmlElement(name="horizontalDatum")
  private HorizontalDatum horizontalDatum = null;

  @XmlElement(name="horizontalMethod")
  private HorizontalMethod horizontalMethod = null;

  @XmlElement(name="altitudeAccuracy")
  private Integer altitudeAccuracy = null;
  
  @XmlElement(name="altitudeDatum")
  private AltitudeDatum altitudeDatum = null;
  
  @XmlElement(name="altitudeMethodCode")  
  private AltitudeMethod altitudeMethodCode = null;

 /**
   * Get geometry
   * @return geometry
  **/
  public Point getGeometry() {
    return geometry;
  }
  public void setGeometry(Point geometry) {
    this.geometry = geometry;
  }
 /**
   * Get horizontalAccuracy
   * @return horizontalAccuracy
  **/
  public HorizontalAccuracy getHorizontalAccuracy() {
    return horizontalAccuracy;
  }
  public void setHorizontalAccuracy(HorizontalAccuracy horizontalAccuracy) {
    this.horizontalAccuracy = horizontalAccuracy;
  }
 /**
   * Get horizontalDatum
   * @return horizontalDatum
  **/
  public HorizontalDatum getHorizontalDatum() {
    return horizontalDatum;
  }
  public void setHorizontalDatum(HorizontalDatum horizontalDatum) {
    this.horizontalDatum = horizontalDatum;
  }
 /**
   * Get horizontalMethod
   * @return horizontalMethod
  **/
  public HorizontalMethod getHorizontalMethod() {
    return horizontalMethod;
  }
  public void setHorizontalMethod(HorizontalMethod horizontalMethod) {
    this.horizontalMethod = horizontalMethod;
  }
 /**
   * Altitude accuracy in meters
   * @return altitudeAccuracy
  **/
  public Integer getAltitudeAccuracy() {
    return altitudeAccuracy;
  }
  public void setAltitudeAccuracy(Integer altitudeAccuracy) {
    this.altitudeAccuracy = altitudeAccuracy;
  }
 /**
   * Get altitudeDatum
   * @return altitudeDatum
  **/
  public AltitudeDatum getAltitudeDatum() {
    return altitudeDatum;
  }
  public void setAltitudeDatum(AltitudeDatum altitudeDatum) {
    this.altitudeDatum = altitudeDatum;
  }
 /**
   * Get altitudeMethodCode
   * @return altitudeMethodCode
  **/
  public AltitudeMethod getAltitudeMethodCode() {
    return altitudeMethodCode;
  }
  public void setAltitudeMethodCode(AltitudeMethod altitudeMethodCode) {
    this.altitudeMethodCode = altitudeMethodCode;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Feature {\n");
    
    sb.append("    geometry: ").append(toIndentedString(geometry)).append("\n");
    sb.append("    horizontalAccuracy: ").append(toIndentedString(horizontalAccuracy)).append("\n");
    sb.append("    horizontalDatum: ").append(toIndentedString(horizontalDatum)).append("\n");
    sb.append("    horizontalMethod: ").append(toIndentedString(horizontalMethod)).append("\n");
    sb.append("    altitudeAccuracy: ").append(toIndentedString(altitudeAccuracy)).append("\n");
    sb.append("    altitudeDatum: ").append(toIndentedString(altitudeDatum)).append("\n");
    sb.append("    altitudeMethodCode: ").append(toIndentedString(altitudeMethodCode)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private static String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

