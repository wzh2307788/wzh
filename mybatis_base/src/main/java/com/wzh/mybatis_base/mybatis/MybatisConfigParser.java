package com.wzh.mybatis_base.mybatis;


import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;

//@Configuration
public class MybatisConfigParser {
   // @Autowired
    MybatisConfig config;
   // @Bean
  /*  public SqlSessionFactory sqlSessionFactory() {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        org.apache.ibatis.session.Configuration configuration = new
                org.apache.ibatis.session.Configuration();

        TransactionFactory transactionFactory= new JdbcTransactionFactory();
        DataSourceFactory dataSourceFactory = new PooledDataSourceFactory();
        Properties properties=new Properties();
        properties.put("driver", config.getDriver());
        properties.put("url",config.getUrl());
        properties.put("username",config.getUsername());
        dataSourceFactory.setProperties(properties);
        DataSource dataSource=dataSourceFactory.getDataSource();


        Environment env=new Environment("dev",transactionFactory,dataSource);
        configuration.setEnvironment(env);
        SqlSessionFactory sqlSessionFactory   = builder.build(configuration);
        return sqlSessionFactory;

    }*/

}
