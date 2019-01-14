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

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages="com.st11.dbshowapi.repository", sqlSessionFactoryRef = "maindbSessionFactory")
public class MainDBConfig {

    private static final String MAINDBPREFIX = "spring.datasource.maindb";

    @Bean(name= "maindbDataSource")
    @ConfigurationProperties(prefix = MainDBConfig.MAINDBPREFIX)
    public DataSource maindbDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name= "maindbSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("maindbDataSource") DataSource maindbDataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(maindbDataSource);
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mybatis/mapper/sqasMapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "maindbSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
