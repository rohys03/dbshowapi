package com.st11.dbshowapi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@MapperScan(basePackages="com.st11.dbshowapi.repository", sqlSessionFactoryRef = "maindbSessionFactory")
@EnableJpaRepositories(basePackages= "com.st11.dbshowapi.jpa", entityManagerFactoryRef = "maindbEntityManagerFactory")
public class MainDBConfig {

    private static final String MAINDBPREFIX = "spring.datasource.maindb";

    @Bean(name= "maindbDataSource")
    @Primary
    @ConfigurationProperties(prefix = MainDBConfig.MAINDBPREFIX)
    public DataSource maindbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name= "maindbSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("maindbDataSource") DataSource maindbDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(maindbDataSource);
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "maindbSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean(name = "maindbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("maindbDataSource") DataSource maindbDataSource) {
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(maindbDataSource);
        entityManagerFactory.setPackagesToScan(new String[] {"com.st11.dbshowapi.jpa"});
        entityManagerFactory.setJpaPropertyMap(properties);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactory;
    }
}
