package br.com.codefield.exemplos.app_completo.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Classe para definir as configurações básicas do Spring/Hibernate
 *
 * @author carlos.oliveira
 * @since 2016-09-20
 */
public class BeansDefault {

    /**
     * Determinda a Configuração com o BD
     *
     * @return O {@link DataSource} que repreenta a conexão com o BD
     */
    @Bean(name = "dataSource")
    public DataSource getDateDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.hsqldb.jdbcDriver");
        ds.setUrl("jdbc:hsqldb:mem:testDB");
        ds.setUsername("sa");
        ds.setPassword("sa");

        return ds;
    }

    /**
     * Configurações do Hibernate
     *
     * @return properties
     */
    public Properties getProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        return properties;
    }

    @Autowired
    @Bean(name = "transactionManager")
    public JpaTransactionManager getTransactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    /**
     * Configura os pacotes/classes a serem utilizados pelo Hibernate
     *
     * @param dataSource
     * @return o entityManagerFactory
     */
    @Autowired
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("br.com.codefield.exemplos.app_completo.api.modelo");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(getProperties());

        return emf;
    }


}
