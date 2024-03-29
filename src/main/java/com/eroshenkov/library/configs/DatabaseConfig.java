package com.eroshenkov.library.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

  @Value("${db.driver}")
  private String DB_DRIVER;

  @Value("${db.password}")
  private String DB_PASSWORD;

  @Value("${db.url}")
  private String DB_URL;

  @Value("${db.username}")
  private String DB_USERNAME;

  @Value("${hibernate.dialect}")
  private String HIBERNATE_DIALECT;

  @Value("${hibernate.show_sql}")
  private String HIBERNATE_SHOW_SQL;

  @Value("${hibernate.hbm2ddl.auto}")
  private String HIBERNATE_HBM2DDL_AUTO;

  @Value("${entitymanager.packagesToScan}")
  private String ENTITYMANAGER_PACKAGES_TO_SCAN;

  @Autowired private DataSource dataSource;
  @Autowired private LocalContainerEntityManagerFactoryBean entityManagerFactory;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DB_DRIVER);
    dataSource.setUrl(DB_URL);
    dataSource.setUsername(DB_USERNAME);
    dataSource.setPassword(DB_PASSWORD);
    return dataSource;
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory =
        new LocalContainerEntityManagerFactoryBean();
    entityManagerFactory.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
    entityManagerFactory.setDataSource(dataSource);
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

    // Hibernate properties
    Properties additionalProperties = new Properties();
    additionalProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
    additionalProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
    additionalProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
    entityManagerFactory.setJpaProperties(additionalProperties);

    return entityManagerFactory;
  }

  /** Declare the transaction manager. */
  @Bean
  public JpaTransactionManager transactionManager() {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory.getObject());
    return transactionManager;
  }

  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
    return new PersistenceExceptionTranslationPostProcessor();
  }
} // class DatabaseConfig
