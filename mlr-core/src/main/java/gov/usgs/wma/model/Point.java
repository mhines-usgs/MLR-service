package gov.usgs.wma.model;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "Point", propOrder =
    { "latitude", "longitude", "altitude"
})

@XmlRootElement(name="Point")

public class Point  {

  @XmlElement(name="latitude")
  private BigDecimal latitude = null;

  @XmlElement(name="longitude")
  private BigDecimal longitude = null;

  @XmlElement(name="altitude")
  private BigDecimal altitude = null;

 /**
   * Get latitude
   * @return latitude
  **/
  public BigDecimal getLatitude() {
    return latitude;
  }
  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }
 /**
   * Get longitude
   * @return longitude
  **/
  public BigDecimal getLongitude() {
    return longitude;
  }
  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }
 /**
   * Get altitude
   * @return altitude
  **/
  public BigDecimal getAltitude() {
    return altitude;
  }
  public void setAltitude(BigDecimal altitude) {
    this.altitude = altitude;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Point {\n");
    
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    altitude: ").append(toIndentedString(altitude)).append("\n");
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

