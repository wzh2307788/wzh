package com.wzh.mybatis_base.mybatis;

import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
 //@PropertySource(value = {"classpath:application.properties"},encoding="utf-8"
@ConfigurationProperties(prefix = "mybatis")
public class MybatisConfig {
    @Property
    String username;
    String driver;
    String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
