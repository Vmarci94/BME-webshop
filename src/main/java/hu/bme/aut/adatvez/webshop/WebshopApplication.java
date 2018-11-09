package hu.bme.aut.adatvez.webshop;

import javax.sql.DataSource;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.ContextResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ConnectionProperties.class})
public class WebshopApplication{
	

	@Autowired
	ConnectionProperties connectionProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(WebshopApplication.class, args);
	}


	@Bean
	public EmbeddedServletContainerFactory tomcatFactory() {

		 return new TomcatEmbeddedServletContainerFactory() {

			@Override
			protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(Tomcat tomcat) {
				tomcat.enableNaming();
				return super.getTomcatEmbeddedServletContainer(tomcat);
			}
			
			@Override
			protected void postProcessContext(Context context) {
				ContextResource resource = new ContextResource();
				resource.setName("jdbc/termekDB");
				resource.setType(DataSource.class.getName());
				resource.setProperty("driverClassName", "oracle.jdbc.OracleDriver");
				resource.setProperty("url", "jdbc:oracle:thin:@localhost:1521:XE");
				resource.setProperty("username", connectionProperties.getUsername());
				resource.setProperty("password", connectionProperties.getPassword());
				resource.setProperty("factory", "org.apache.tomcat.jdbc.pool.DataSourceFactory");

				context.getNamingResources().addResource(resource);
			}
		
		};
	}
	
}
