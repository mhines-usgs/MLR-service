package gov.usgs.wma.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gov.usgs.wma.model.MonitoringLocation;
import gov.usgs.wma.mapper.MonitoringLocationMapper;

/**
 *
 * @author zmoore
 */
public class MonitoringLocationDAO implements IMonitoringLocationDAO {
	private static final Logger LOG = LoggerFactory.getLogger(MonitoringLocationDAO.class);
	
	private SqlSessionFactory sessionFactory;

	public MonitoringLocationDAO(MonitoringLocationDAOFactory MLDAOFacotry) {
		this.sessionFactory = MLDAOFacotry.getSqlSessionFactory();
	}
	
	@Override
	public List<MonitoringLocation> getMonitoringLocations(Map<String, Object> params) {
		List<MonitoringLocation> monitoringLocations = null;
		
		try (SqlSession session = sessionFactory.openSession()) {
			LOG.debug("Loading Monitoring Locations for params ", params.toString());
			MonitoringLocationMapper mapper = session.getMapper(MonitoringLocationMapper.class);
			monitoringLocations = mapper.getMonitoringLocations(params);
		}
		
		return monitoringLocations;
	}
	
	@Override
	public MonitoringLocation createMonitoringLocation(MonitoringLocation newMonitoringLocation){
		//TODO - Persist and re-fetch for return
		return newMonitoringLocation;
	}
}
