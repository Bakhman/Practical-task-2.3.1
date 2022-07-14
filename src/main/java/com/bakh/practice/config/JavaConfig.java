package com.bakh.practice.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManager;
import java.util.Properties;

/**
 * @author Bakhmai Begaev
 */
@Configuration
@ComponentScan("com.bakh.practice")
@PropertySource("classpath:hibernate.properties")
public class JavaConfig {

    private Properties properties = new Properties();

    @Bean
    public EntityManager em(){
        properties.put("javax.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver.class");
        properties.put("javax.persistence.jdbc.url", "jdbc:mysql://localhost:3306/db113");
        properties.put("javax.persistence.jdbc.user", "bakhman");
        properties.put("javax.persistence.jdbc.password", "bakhmai");

        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPackagesToScan("com.bakh.practice");
        emf.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        emf.setPersistenceUnitName("");
        emf.afterPropertiesSet();

        return emf.getObject().createEntityManager();
    }
}
