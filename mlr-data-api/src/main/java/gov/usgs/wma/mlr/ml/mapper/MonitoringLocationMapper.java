package gov.usgs.wma.mlr.ml.mapper;

import java.util.List;
import java.util.Map;

/**
 * Common Interface for mybatis MLEntityMappers
 * 
 * @author zmoore
 */
public interface MonitoringLocationMapper {
	List<Object> getMonitoringLocations(Map<String, Object> parms);
	int getCount();
	void insertMonitoringLocation(Object record);
}
