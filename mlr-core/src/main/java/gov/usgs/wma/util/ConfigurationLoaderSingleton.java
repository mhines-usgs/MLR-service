package gov.usgs.wma.util;

import gov.usgs.cida.config.DynamicReadOnlyProperties;

import java.util.Properties;

import javax.naming.NamingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A singleton that handles loading of configuration properties for MLR using 
 * the DynamicReadOnlyProperties loader
 * 
 * @author thongsav
 */
public class ConfigurationLoaderSingleton {

	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationLoaderSingleton.class);
	private static DynamicReadOnlyProperties props = null;

	private static DynamicReadOnlyProperties getInstance() {
		if (null == props) {
			try {
				props = new DynamicReadOnlyProperties().addJNDIContexts();
			} catch (NamingException e) {
				LOG.warn("Error occured during initProps()", e);
			}
		}
		return props;
	}
	
	/**
	 * A wrapper function to get a property value given the property name
	 * 
	 * @param prop
	 * @return
	 */
	public static String getProperty(String prop) {
		return getInstance().getProperty(prop);
	}
	
	public static Properties getProps() {
		return props;
	}
}