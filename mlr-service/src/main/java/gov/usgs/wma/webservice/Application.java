package gov.usgs.wma.webservice;

import org.glassfish.jersey.servlet.ServletContainer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class)
        	.run(args);
	}
	
	@Bean
	public ServletRegistrationBean jerseyServlet() {
	    ServletRegistrationBean registration = new ServletRegistrationBean(new ServletContainer(), "/*");
	    // our rest resources will be available in the path /rest/*
	    registration.addInitParameter("javax.ws.rs.Application", MlrWebservicesEntryPoint.class.getCanonicalName());
	    return registration;
	}
}