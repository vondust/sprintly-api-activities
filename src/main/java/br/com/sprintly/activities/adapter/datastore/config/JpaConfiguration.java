package br.com.sprintly.activities.adapter.datastore.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaAuditing
@EnableJpaRepositories({ "br.com.sprintly" })
@PropertySource("classpath:application.properties")
public class JpaConfiguration {

	@Autowired
	private Environment env;

	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
		LocalContainerEntityManagerFactoryBean containerEntityFactory = new LocalContainerEntityManagerFactoryBean();
		containerEntityFactory.setPersistenceUnitName("JpaUnit");
		containerEntityFactory.setPackagesToScan("br.com.sprintly");
		containerEntityFactory.setJpaVendorAdapter(getJpaVendorAdapter());
		containerEntityFactory.setDataSource(getDataSource());
		containerEntityFactory.setJpaProperties(jpaAdditionalProperties());
		return containerEntityFactory;
	}
	
	@Bean(name = "transactionManager")
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(getEntityManagerFactoryBean().getObject());
	}

	@Bean
	public JpaVendorAdapter getJpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public DataSource getDataSource() {
		return DataSourceBuilder.create()
				.url(env.getProperty("spring.datasource.url"))
				.driverClassName(env.getProperty("spring.datasource.driver-class-name"))
				.username(env.getProperty("spring.datasource.username"))
				.password(env.getProperty("spring.datasource.password"))
				.build();
	}

	private Properties jpaAdditionalProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty("spring.jpa.database-platform"));
		properties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		properties.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
		properties.put("hibernate.id.new_generator_mappings", env.getProperty("spring.jpa.hibernate.use-new-id-generator-mappings"));
		return properties;
	}
	
}
