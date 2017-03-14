package com.rodrigo.myshare.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@Configuration
@PropertySource("app.properties")
public class DataConfig {

    @Autowired
    Environment env;

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setConfigLocation(config);
        sessionFactory.setPackagesToScan(env.getProperty("myshare.entity.package"));
        sessionFactory.setDataSource(dataSource());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
      BasicDataSource ds = new BasicDataSource();

      //Set Driver class
      ds.setDriverClassName(env.getProperty("myshare.db.driver"));

      //Set URL
      ds.setUrl(env.getProperty("myshare.db.url"));

      //Set username and password
      ds.setUsername(env.getProperty("myshare.db.username"));
      ds.setPassword(env.getProperty("myshare.db.password"));
      return ds;
    }
}
