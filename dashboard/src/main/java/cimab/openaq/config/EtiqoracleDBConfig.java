package cimab.openaq.config;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
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

import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import com.jcraft.jsch.*;
import java.util.logging.Level;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "etiqoracleXEntityManagerFactory", transactionManagerRef = "etiqoracleXTransactionManager", basePackages = {
        "cimab.openaq.repository.etiqoracle" })
public class EtiqoracleDBConfig {
    @Bean(name = "etiqoracleXDataSource")
    @ConfigurationProperties(prefix = "spring.etiqoracle.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "etiqoracleXEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean etiqoracleXEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                                  @Qualifier("etiqoracleXDataSource") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();

        // properties.put("hibernate.hbm2ddl.auto", "none");
        properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        // properties.put("hibernate.hbm2ddl.auto", "update");
        // con "update" crea nuevos objetos en base de datos !!!!!!!!!!!!!!!
        properties.put("hibernate.hbm2ddl.auto", "none");
        java.util.Properties config = new java.util.Properties();
        JSch jsch = new JSch();
        HashMap<String, Object> hMap = null;


        // Create SSH session.  Port 22 is your SSH port which
        // is open in your firewall setup.
        try {
            Session session = jsch.getSession("jairoceron", "192.168.175.93", 22);
            session.setPassword("V5f0+0veju+z7YECF\\xH");  // :: ese slash sobra en original es con un solo slash

// firewall-cmd --add-port 1191/tcp


         //   Session session = jsch.getSession("jairoc", "192.168.175.39", 22);
         //    session.setPassword("qY^lB:aSS/Ybz'E");  // ::

            // Additional SSH options.  See your ssh_config manual for
            // more options.  Set options according to your requirements.



            config.put("StrictHostKeyChecking", "no");
          //  config.put("Compression", "yes");
          //  config.put("ConnectionAttempts", "2");



            session.setConfig(config);
            hMap = typeCastConvert(config);
            // https://stackoverflow.com/questions/62837731/connect-to-db-using-ssh-java
            // Connect
            session.connect();
             int localPort = 61521;
            //int localPort = 22;
             int assigned_port = session.setPortForwardingL(localPort,"172.22.1.24", 1521);

            // int assigned_port = session.setPortForwardingL(localPort,"172.22.1.24", 1521);

            Channel channel=session.openChannel("exec");
            channel.connect();
            System.out.println("la conexion ssh se establecio con exito :::: " + session  + " puerto " + assigned_port );
        } catch (com.jcraft.jsch.JSchException dd) {
            dd.printStackTrace();
        }


        return builder.dataSource(dataSource).properties(hMap)
                .packages("cimab.openaq.entity.etiqoracle").persistenceUnit("Etiqoracle").build();
    }

    @Bean(name = "etiqoracleXTransactionManager")
    public PlatformTransactionManager etiqoracleXTransactionManager(
            @Qualifier("etiqoracleXEntityManagerFactory") EntityManagerFactory etiqoracleXEntityManagerFactory) {
        return new JpaTransactionManager(etiqoracleXEntityManagerFactory);
    }

    public static HashMap<String, Object> typeCastConvert(Properties prop) {
        Map step1 = prop;
        Map<String, Object> step2 = (Map<String, Object>) step1;
        return new HashMap<>(step2);
    }

}
