package com.st11.dbshowapi.config;

import org.apache.ibatis.session.SqlSessionFactory;
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

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@MapperScan(basePackages="com.st11.dbshowapi.repository", sqlSessionFactoryRef = "dadbSessionFactory")
@EnableJpaRepositories(basePackages= "com.st11.dbshowapi.jpa", entityManagerFactoryRef = "dadbEntityManagerFactory")
public class DaDBConfig {

    private static final String DADBPREFIX = "spring.datasource.dadb";

    @Bean(name= "dadbDataSource")
    @Primary
    @ConfigurationProperties(prefix = DaDBConfig.DADBPREFIX)
    public DataSource maindbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name= "dadbSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dadbDataSource") DataSource dadbDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dadbDataSource);
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "dadbSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Primary
    @Bean(name = "dadbEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("dadbDataSource") DataSource dadbDataSource) {
        HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dadbDataSource);
        entityManagerFactory.setPackagesToScan(new String[] {"com.st11.dbshowapi.jpa"});
        entityManagerFactory.setJpaPropertyMap(properties);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

        return entityManagerFactory;
    }
}
