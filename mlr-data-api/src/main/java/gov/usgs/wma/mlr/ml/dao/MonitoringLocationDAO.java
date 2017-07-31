package gov.usgs.wma.mlr.ml.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.mlr.ml.mapper.MonitoringLocationMapper;
//import gov.usgs.wma.mlr.ml.model.MonitoringLocation;

/**
 *
 * @author zmoore
 */
public class MonitoringLocationDAO {
	private static final Logger LOG = LoggerFactory.getLogger(MonitoringLocationDAO.class);
	
	private SqlSessionFactory sessionFactory;

	public MonitoringLocationDAO(MonitoringLocationDAOFactory MLDAOFacotry) {
		this.sessionFactory = MLDAOFacotry.getSqlSessionFactory();
	}
	
	public List<MonitoringLocation> getMonitoringLocations() {
		return getMonitoringLocations(new HashMap<String,Object>());
	}
	
	public MonitoringLocation getMonitoringLocation(String id){
		MonitoringLocation returnLocation = null;
		List<MonitoringLocation> monitoringLocations = null;
		Map<String,Object> params = new HashMap<>();
		
		params.put("id", id);
		
		monitoringLocations = getMonitoringLocations(params);
		
		if(monitoringLocations != null){
			if(monitoringLocations.size() > 1){
				LOG.error("Duplicate MonitoringLocation Entities Found for ID: " + id);
			} else if(monitoringLocations.size() == 1) {
				returnLocation = monitoringLocations.toArray()[0];
			}
		}
		
		
		return returnLocation;
	}
	
	public List<MonitoringLocation> getMonitoringLocations(Map<String, Object> params) {
		List<MonitoringLocation> monitoringLocations = null;
		
		try (SqlSession session = sessionFactory.openSession()) {
			LOG.debug("Loading ML Entities for params", params.toString());
			MonitoringLocationMapper mapper = session.getMapper(MonitoringLocationMapper.class);
			monitoringLocations = mapper.getMonitoringLocations(params);
		}
		
		return monitoringLocations;
	}
}
