package gov.usgs.wma.model;

import gov.usgs.wma.model.Agency;
import gov.usgs.wma.model.Aquifer;
import gov.usgs.wma.model.Country;
import gov.usgs.wma.model.County;
import gov.usgs.wma.model.Feature;
import gov.usgs.wma.model.HydrologicUnit;
import gov.usgs.wma.model.MinorCivilDivisionCode;
import gov.usgs.wma.model.MonitoringLocationType;
import gov.usgs.wma.model.NationalAquifer;
import gov.usgs.wma.model.State;
import gov.usgs.wma.model.Use;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name = "MonitoringLocation", propOrder =
    { "id", "locationNumber", "name", "agency", "primaryAgency", "number", "monitoringLocationType", "uses", "locationGeometry", "country", "state", "county", "minorCivilDivisionCode", "hydrologicUnit", "nationalAquifer", "aquifer"
})

@XmlRootElement(name="MonitoringLocation")
public class MonitoringLocation  {
  
  @XmlElement(name="id")
  private Long id = null;

  @XmlElement(name="locationNumber")
  private String locationNumber = null;

  @XmlElement(name="name")
  private String name = null;

  @XmlElement(name="agency")
  private List<Agency> agency = new ArrayList<Agency>();

  @XmlElement(name="primaryAgency")
  private List<Agency> primaryAgency = new ArrayList<Agency>();

  @XmlElement(name="number")
  private Long number = null;

  @XmlElement(name="monitoringLocationType")
  private MonitoringLocationType monitoringLocationType = null;

  @XmlElement(name="uses")
  private List<Use> uses = new ArrayList<Use>();

  @XmlElement(name="locationGeometry")
  private Feature locationGeometry = null;

  @XmlElement(name="country")
  private Country country = null;

  @XmlElement(name="state")
  private State state = null;

  @XmlElement(name="county")
  private County county = null;

  @XmlElement(name="minorCivilDivisionCode")
  private MinorCivilDivisionCode minorCivilDivisionCode = null;

  @XmlElement(name="hydrologicUnit")
  private HydrologicUnit hydrologicUnit = null;

  @XmlElement(name="nationalAquifer")
  private NationalAquifer nationalAquifer = null;

  @XmlElement(name="aquifer")
  private Aquifer aquifer = null;

 /**
   * artificial key for the location, assigned by database
   * @return id
  **/
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
 /**
   * natural site number for site
   * @return locationNumber
  **/
  public String getLocationNumber() {
    return locationNumber;
  }
  public void setLocationNumber(String locationNumber) {
    this.locationNumber = locationNumber;
  }
 /**
   * the name of the monitoring location
   * @return name
  **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
 /**
   * the agencies that are associated with a site
   * @return agency
  **/
  public List<Agency> getAgency() {
    return agency;
  }
  public void setAgency(List<Agency> agency) {
    this.agency = agency;
  }
 /**
   * what agency is primarily responsible for the site.  Would be the agency in legacy NWIS
   * @return primaryAgency
  **/
  public List<Agency> getPrimaryAgency() {
    return primaryAgency;
  }
  public void setPrimaryAgency(List<Agency> primaryAgency) {
    this.primaryAgency = primaryAgency;
  }
 /**
   * the exisitng NWIS site number
   * @return number
  **/
  public Long getNumber() {
    return number;
  }
  public void setNumber(Long number) {
    this.number = number;
  }
 /**
   * Get monitoringLocationType
   * @return monitoringLocationType
  **/
  public MonitoringLocationType getMonitoringLocationType() {
    return monitoringLocationType;
  }
  public void setMonitoringLocationType(MonitoringLocationType monitoringLocationType) {
    this.monitoringLocationType = monitoringLocationType;
  }
 /**
   * the uses associated with the site
   * @return uses
  **/
  public List<Use> getUses() {
    return uses;
  }
  public void setUses(List<Use> uses) {
    this.uses = uses;
  }
 /**
   * Get locationGeometry
   * @return locationGeometry
  **/
  public Feature getLocationGeometry() {
    return locationGeometry;
  }
  public void setLocationGeometry(Feature locationGeometry) {
    this.locationGeometry = locationGeometry;
  }
 /**
   * Get country
   * @return country
  **/
  public Country getCountry() {
    return country;
  }
  public void setCountry(Country country) {
    this.country = country;
  }
 /**
   * Get state
   * @return state
  **/
  public State getState() {
    return state;
  }
  public void setState(State state) {
    this.state = state;
  }
 /**
   * Get county
   * @return county
  **/
  public County getCounty() {
    return county;
  }
  public void setCounty(County county) {
    this.county = county;
  }
 /**
   * Get minorCivilDivisionCode
   * @return minorCivilDivisionCode
  **/
  public MinorCivilDivisionCode getMinorCivilDivisionCode() {
    return minorCivilDivisionCode;
  }
  public void setMinorCivilDivisionCode(MinorCivilDivisionCode minorCivilDivisionCode) {
    this.minorCivilDivisionCode = minorCivilDivisionCode;
  }
 /**
   * Get hydrologicUnit
   * @return hydrologicUnit
  **/
  public HydrologicUnit getHydrologicUnit() {
    return hydrologicUnit;
  }
  public void setHydrologicUnit(HydrologicUnit hydrologicUnit) {
    this.hydrologicUnit = hydrologicUnit;
  }
 /**
   * Get nationalAquifer
   * @return nationalAquifer
  **/
  public NationalAquifer getNationalAquifer() {
    return nationalAquifer;
  }
  public void setNationalAquifer(NationalAquifer nationalAquifer) {
    this.nationalAquifer = nationalAquifer;
  }
 /**
   * Get aquifer
   * @return aquifer
  **/
  public Aquifer getAquifer() {
    return aquifer;
  }
  public void setAquifer(Aquifer aquifer) {
    this.aquifer = aquifer;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MonitoringLocation {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    locationNumber: ").append(toIndentedString(locationNumber)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    agency: ").append(toIndentedString(agency)).append("\n");
    sb.append("    primaryAgency: ").append(toIndentedString(primaryAgency)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    monitoringLocationType: ").append(toIndentedString(monitoringLocationType)).append("\n");
    sb.append("    uses: ").append(toIndentedString(uses)).append("\n");
    sb.append("    locationGeometry: ").append(toIndentedString(locationGeometry)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    county: ").append(toIndentedString(county)).append("\n");
    sb.append("    minorCivilDivisionCode: ").append(toIndentedString(minorCivilDivisionCode)).append("\n");
    sb.append("    hydrologicUnit: ").append(toIndentedString(hydrologicUnit)).append("\n");
    sb.append("    nationalAquifer: ").append(toIndentedString(nationalAquifer)).append("\n");
    sb.append("    aquifer: ").append(toIndentedString(aquifer)).append("\n");
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

