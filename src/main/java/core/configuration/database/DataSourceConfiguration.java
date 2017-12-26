package core.configuration.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Altair on 19.12.2017.
 */
@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfiguration {

  @Value("${jdbc.driver}")
  private String driver;

  @Value("${jdbc.url}")
  private String url;

  @Value("${jdbc.user}")
  private String user;

  @Value("${jdbc.password}")
  private String password;

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Bean(name = "dataSource")
  public DataSource dataSource() {
    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource(url, user, password);
    driverManagerDataSource.setDriverClassName(driver);
    return driverManagerDataSource;
  }
}