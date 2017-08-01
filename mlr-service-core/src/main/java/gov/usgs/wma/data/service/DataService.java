/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.wma.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gov.usgs.wma.model.MonitoringLocation;
import gov.usgs.wma.dao.IMonitoringLocationDAO;

/**
 *
 * @author dpatterm
 */
public class DataService {
	
	private static final Logger log = LoggerFactory.getLogger(DataService.class);
	private IMonitoringLocationDAO monitoringLocationDao;
	
	public DataService(IMonitoringLocationDAO monitoringLocationDao) {
		this.monitoringLocationDao = monitoringLocationDao;
	}
		
	public MonitoringLocation getMonitoringLocationByLocationNumber(Long locationNumber){
		MonitoringLocation location;
		location = monitoringLocationDao.getMonitoringLocationByLocationNumber(locationNumber);
		return location;
	}

}
