package gov.usgs.wma.mlr.ml.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.mlr.ml.mapper.MonitoringLocationMapper;

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
	
	public List<Object> getMonitoringLocations() {
		return getMonitoringLocations(new HashMap<String,Object>());
	}
	
	public Object getMonitoringLocation(String id){
		List<Object> mlEntities = null;
		Map<String,Object> params = new HashMap<>();
		
		params.put("id", id);
		
		getMonitoringLocations(params);
		
		return mlEntities;
	}
	
	public List<Object> getMonitoringLocations(Map<String, Object> params) {
		List<Object> mlEntities = null;
		
		try (SqlSession session = sessionFactory.openSession()) {
			LOG.debug("Loading ML Entities for params", params.toString());
			MonitoringLocationMapper mapper = session.getMapper(MonitoringLocationMapper.class);
			mlEntities = mapper.getMonitoringLocations(params);
		}
		
		return mlEntities;
	}
}
