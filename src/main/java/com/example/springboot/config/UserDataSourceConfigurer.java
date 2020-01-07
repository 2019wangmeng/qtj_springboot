package com.example.springboot.config;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @Author: WangM
 * @Description:
 * @Date: 14:14 2020/1/7
 */
@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "userEntityManager",
        basePackages = {"com.example.springboot.repository"})
public class UserDataSourceConfigurer {
    @Autowired
    private JpaVendorAdapter jpaVendorAdapter;

    @Bean(name = "userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dbuser")
    public DataSource dataSource(){
        AtomikosDataSourceBean xaDataSource  = new AtomikosDataSourceBean();
        return xaDataSource;
    }

    @Bean(name = "userEntityManager")
    @DependsOn("transactionManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.transaction.jta.platform", XATransactionConfig.AtomikosJtaPlatform.class.getName());
        properties.put("javax.persistence.transactionType", "JTA");
        properties.put("hibernate.physical_naming_strategy", SpringPhysicalNamingStrategy.class.getName());
        properties.put("hibernate.implicit_naming_strategy", SpringImplicitNamingStrategy.class.getName());

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setJtaDataSource(dataSource());
        entityManager.setJpaVendorAdapter(jpaVendorAdapter);
        // 设置为该EntityManager所要管理的Entity类所在的包
        entityManager.setPackagesToScan("com.example.springboot.entity");
        entityManager.setPersistenceUnitName("userPersistenceUnit");
        entityManager.setJpaPropertyMap(properties);
        return entityManager;
    }
}
