/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gov.usgs.wma.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import gov.usgs.wma.model.MonitoringLocation;

/**
 *
 * @author dpatterm
 */
public class DataService {
	
	private static final Logger log = LoggerFactory.getLogger(DataService.class);
	private IMonitoringLocationDao monitoringLocationDao;
	
	public DataService(IMonitoringLocationDAO monitoringLocationDao) {
		this.monitoringLocationDao = monitoringLocationDao;
	}
	
	public MonitoringLocation getMonitoringLocation(Long id){
		MonitoringLocation location;
		location = monitoringLocationDao.getMonitoringLocationById(id);
		return location;
	}

}
