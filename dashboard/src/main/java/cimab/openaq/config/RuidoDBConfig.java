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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "rdoXEntityManagerFactory", transactionManagerRef = "rdoXTransactionManager", basePackages = {
        "cimab.openaq.repository.ruido" })
public class  RuidoDBConfig {

    @Bean(name = "rdoXDataSource")
    @ConfigurationProperties(prefix = "spring.ruido.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "rdoXEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean rdoXEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("rdoXDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "none");
       //  properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
        //spring.jpa.database-platform=org.hibernate.spatial.dialect.postgis.PostgisDialect
        return builder.dataSource(dataSource).properties(properties)
                .packages("cimab.openaq.entity.ruido").persistenceUnit("Ruido").build();
    }

    @Bean(name = "rdoXTransactionManager")
    public PlatformTransactionManager rdoXTransactionManager(
            @Qualifier("rdoXEntityManagerFactory") EntityManagerFactory rdoXEntityManagerFactory) {
        return new JpaTransactionManager(rdoXEntityManagerFactory);
    }
}