/** ************************************************************************
 * Copyright (C) 2022 Mob Army S.R.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential.
 * Written by Mob Army <info@wwtelecommunications.com>, 2022
 * for Mob Army S.R.L. use only.
 * *************************************************************************
 */
package bo.tigo.mob.k8s.getdevicesavailable.util.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariDataSource;

import bo.tigo.mob.k8s.getdevicesavailable.util.AElog;

/**
 * MyBatisConfig
 *
 * @author Elio Arias
 * @since 1.0
 * @version Revision-2021-07-25
 */
@Configuration
@MapperScan(basePackages = "bo.tigo.mob.k8s.getdevicesavailable.dao.ds1", sqlSessionFactoryRef = "oneSqlSessionFactory")
public class MyBatisConfig {
    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Value("${mobarmy.properties.source}")
    private String source;

    @Value("${mybatis.mapper-locations}")
    private String mybatis_mapper_locations;

    @Primary
    @Bean(name = "oneDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.one.hikari")
    public DataSource primaryDataSource() {
        AElog.infoX(logger, "El proceso primaryDataSource() fue invocado. Properties: " + source);
        // for HikariDataSource use:
        // Option 0: Spring Boot by default uses HikariDataSource
        // Option 1: spring.datasource.xyz.type=com.zaxxer.hikari.HikariDataSource
        // Option 2: DataSourceBuilder.create().type(HikariDataSource.class).build();
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "oneSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("oneDataSource") DataSource dataSource) throws Exception {
        AElog.infoX(logger, "El proceso sqlSessionFactory() fue invocado. Properties: " + source);
        HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
        AElog.infoX(logger, "getJdbcUrl: " + hikariDataSource.getJdbcUrl());
        AElog.infoX(logger, "getUsername: *"); // + hikariDataSource.getUsername());
        AElog.infoX(logger, "getPassword: *"); // + hikariDataSource.getPassword());
        AElog.infoX(logger, "getDriverClassName: " + hikariDataSource.getDriverClassName());
        AElog.infoX(logger, "getDataSourceClassName: " + hikariDataSource.getDataSourceClassName());
        AElog.infoX(logger, "getConnectionTimeout: " + hikariDataSource.getConnectionTimeout());
        AElog.infoX(logger, "getMinimumIdle: " + hikariDataSource.getMinimumIdle());
        AElog.infoX(logger, "getMaximumPoolSize: " + hikariDataSource.getMaximumPoolSize());
        AElog.infoX(logger, "getIdleTimeout: " + hikariDataSource.getIdleTimeout());
        AElog.infoX(logger, "getMaxLifetime: " + hikariDataSource.getMaxLifetime());
        AElog.infoX(logger, "isAutoCommit: " + hikariDataSource.isAutoCommit());

        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean
                .setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mybatis_mapper_locations));

        return sessionFactoryBean.getObject();
    }

}
