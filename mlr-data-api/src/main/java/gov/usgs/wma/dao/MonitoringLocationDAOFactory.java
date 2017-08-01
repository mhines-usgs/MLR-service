package gov.usgs.wma.dao;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import gov.usgs.wma.util.ConfigurationLoaderSingleton;

public class MonitoringLocationDAOFactory {
	private static final Object syncLock = new Object();
	
	private static final String MONITORING_LOCATION_DATA_INTERFACE_PROPERTY = "ml.data.interface";
	private static final String MYBATIS_CONFIGURATION_BASE_DIRECOTRY = "mybatis/";
	private static final String DEFAULT_MYBATIS_CONFIGURATION = "postgresql.xml";
	
	private SqlSessionFactory sqlSessionFactory;
	private Properties properties;
	
	public MonitoringLocationDAOFactory(Properties properties) {
		this.properties = properties;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		} else {
			return buildSqlSessionFactory();
		}
	}
	
	private SqlSessionFactory buildSqlSessionFactory() {
		synchronized (syncLock) {
			if (sqlSessionFactory == null) {
				sqlSessionFactory = buildSqlSessionFactory(properties);
			}
			return sqlSessionFactory;
		}
	}
	
	public static SqlSessionFactory buildSqlSessionFactory(Properties properties) throws RuntimeException {
		
		try {
			//Dynamically load the MyBatis Configuration based in order to specify the interface we want to use
			String mybatisProperty = ConfigurationLoaderSingleton.getProperty(MONITORING_LOCATION_DATA_INTERFACE_PROPERTY);
			String resource =  MYBATIS_CONFIGURATION_BASE_DIRECOTRY
					+ (mybatisProperty != null ? mybatisProperty : DEFAULT_MYBATIS_CONFIGURATION);
			InputStream inputStream = Resources.getResourceAsStream(resource);

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
			return sqlSessionFactory;
			
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}
	
}
