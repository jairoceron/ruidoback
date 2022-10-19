package cimab.openaq.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "etiquetadoXEntityManagerFactory", transactionManagerRef = "etiquetadoXTransactionManager", basePackages = {
        "cimab.openaq.repository.etiquetado" })
public class EtiquetadoDBConfig {
    @Bean(name = "etiquetadoXDataSource")
    @ConfigurationProperties(prefix = "spring.etiquetado.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "etiquetadoXEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean etiquetadoXEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("etiquetadoXDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        return builder.dataSource(dataSource).properties(properties)
                .packages("cimab.openaq.entity.etiquetado").persistenceUnit("Etiquetado").build();
    }

    @Bean(name = "etiquetadoXTransactionManager")
    public PlatformTransactionManager etiquetadoXTransactionManager(
            @Qualifier("etiquetadoXEntityManagerFactory") EntityManagerFactory etiquetadoXEntityManagerFactory) {
        return new JpaTransactionManager(etiquetadoXEntityManagerFactory);
    }
}