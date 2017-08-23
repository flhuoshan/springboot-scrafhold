package com.flhscl.springbootscrafhold.config.dbpool;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
public interface IDataSourrceEnvironmentAware extends EnvironmentAware {

    default DruidDataSource setCommonDataSourceProperties(RelaxedPropertyResolver relaxedPropertyResolver) throws SQLException {
        final DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(relaxedPropertyResolver.getProperty("driver-class-name"));
        druidDataSource.setUrl(relaxedPropertyResolver.getProperty("url"));
        druidDataSource.setUsername(relaxedPropertyResolver.getProperty("username"));
        druidDataSource.setPassword(relaxedPropertyResolver.getProperty("password"));
        druidDataSource.setInitialSize(Integer.parseInt(relaxedPropertyResolver.getProperty("initialSize")));
        druidDataSource.setMinIdle(Integer.parseInt(relaxedPropertyResolver.getProperty("minIdle")));
        druidDataSource.setMaxActive(Integer.parseInt(relaxedPropertyResolver.getProperty("maxActive")));
        druidDataSource.setMaxWait(Integer.parseInt(relaxedPropertyResolver.getProperty("maxWait")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(relaxedPropertyResolver.getProperty("timeBetweenEvictionRunsMillis")));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(relaxedPropertyResolver.getProperty("minEvictableIdleTimeMillis")));
        druidDataSource.setValidationQuery(relaxedPropertyResolver.getProperty("validationQuery"));
        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(relaxedPropertyResolver.getProperty("testWhileIdle")));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(relaxedPropertyResolver.getProperty("testOnBorrow")));
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(relaxedPropertyResolver.getProperty("testOnReturn")));
        druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(relaxedPropertyResolver.getProperty("poolPreparedStatements")));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(relaxedPropertyResolver.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        druidDataSource.setFilters(relaxedPropertyResolver.getProperty("filters"));
        return druidDataSource;
    }

}
