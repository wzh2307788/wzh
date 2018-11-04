package com.wzh.mybatis_base.mybatis;

import com.wzh.mybatis_base.h2.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.InputStream;

/**
 * 1、MybatisSerivce constructor
 * 2. BeanNameAware
 * 3  beanfactory
 * 4、 ApplicationContextAware
 * 5、PostConstruct
 * 6、afterPropertiesSet  5,6在设计上等效，实际取其一即可
 * <p>
 * n Spring, you can either implements InitializingBean and DisposableBean interface
 * or specify the init-method and destroy-method in bean configuration file
 * for the initialization and destruction callback function.
 * In this article, we show you how to use
 * annotation @PostConstruct and @PreDestroy to do the same thing.
 */
@Service
public class MybatisSerivce implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean {

    @Autowired
    private Author author;
    SqlSessionFactory sqlSessionFactory;
    private Logger log = LoggerFactory.getLogger(MybatisSerivce.class);

    public MybatisSerivce() {
        log.debug(" 1、MybatisSerivce constructor");
    }


    @PostConstruct
    public void postConstruct() throws IOException {
        log.debug("5、PostConstruct");
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        sqlSessionFactory.getConfiguration().addMapper(RoleMapper.class);
    }

    @Override
    public void setBeanName(String s) {
        log.debug("2. BeanNameAware");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.debug("3  beanfactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.debug("4、 ApplicationContextAware");

    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        System.out.println("2  property set");
        log.debug("2  property set");
        this.author = author;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("6、afterPropertiesSet");
    }

    @PreDestroy
    public void preDestory() {
        log.debug(" last 2 preDestroy");
    }
}
