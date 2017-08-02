package gov.usgs.wma.util;

import gov.usgs.wma.dao.MonitoringLocationDAO;
import gov.usgs.wma.dao.MonitoringLocationDAOFactory;
import gov.usgs.wma.data.service.DataService;

/**
 * TODO This can/should be replaced with dependency injection later.
 * Used right now as a quick way to initialize and share a single DAO factory among
 * the Webservice and MQ APIs
 * @author thongsav
 *
 */
public class MlrInstanceSingleton {
	private static DataService dataService;
	
	public static DataService getDataService() {
		if(dataService == null) {
			dataService = new DataService(
					new MonitoringLocationDAO(
							new MonitoringLocationDAOFactory(ConfigurationLoaderSingleton.getProps())));
		}
		
		return dataService;
	}
}
