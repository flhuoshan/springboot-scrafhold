package com.flhscl.springbootscrafhold.config.dbpool;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 * To change this template use File | Settings | Editor | File and Code Templates
 * Description:
 */

import com.alibaba.druid.util.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Configuration
@MapperScan(basePackages = "com.flhscl.springbootscrafhold.mapper.datasource2", sqlSessionTemplateRef = "datasource2SqlSessionTemplate")
public class DataSource2Config implements IDataSourrceEnvironmentAware {
    private static final Logger logger = LoggerFactory.getLogger(DataSource2Config.class);
    private Environment environment;
    private RelaxedPropertyResolver jifenPropertyResolver;
    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
        this.jifenPropertyResolver = new RelaxedPropertyResolver(environment, "spring.datasource.datasource2.");
    }

    @Bean(name = "datasource2DataSource",initMethod = "init", destroyMethod = "close")
    public DataSource testDataSource() throws SQLException {
        if (StringUtils.isEmpty(jifenPropertyResolver.getProperty("url"))) {
            logger.error("数据库连接池配置错误!"
                    + " 请检查Spring配置文件，目前的配置有："
                    + Arrays.toString(environment.getActiveProfiles()));
            throw new ApplicationContextException(
                    "数据库连接池配置错误");
        }
        return this.setCommonDataSourceProperties(jifenPropertyResolver);
    }

    @Bean(name = "datasource2SqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("datasource2DataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/datasource2/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "datasource2TransactionManager")
    public PlatformTransactionManager testTransactionManager(@Qualifier("datasource2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "datasource2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("datasource2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}