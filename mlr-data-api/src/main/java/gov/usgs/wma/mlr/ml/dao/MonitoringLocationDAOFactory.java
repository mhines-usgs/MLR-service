package gov.usgs.wma.mlr.ml.dao;

import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MonitoringLocationDAOFactory {
	private static final Object syncLock = new Object();
	
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
			//Parameterize this from DROP
			String resource = "mybatis/mybatis.conf.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);

			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
			return sqlSessionFactory;
			
		} catch (Exception e) {
			throw new RuntimeException (e);
		}
	}
	
}
