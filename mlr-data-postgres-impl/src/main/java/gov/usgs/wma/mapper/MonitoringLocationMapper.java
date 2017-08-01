package gov.usgs.wma.mapper;

import java.util.List;
import java.util.Map;

import gov.usgs.wma.model.MonitoringLocation;

/**
 * Common Interface for mybatis MLEntityMappers
 * 
 * @author zmoore
 */
public interface MonitoringLocationMapper {
	List<MonitoringLocation> getMonitoringLocations(Map<String, Object> parms);
	int getCount();
	void insertMonitoringLocation(Object record);
}
