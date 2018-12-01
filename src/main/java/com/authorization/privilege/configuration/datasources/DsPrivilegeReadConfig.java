package com.authorization.privilege.configuration.datasources;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 权限系统读数据源配置类
 */
@Configuration
@MapperScan(basePackages = "com.authorization.privilege.mapper.dsprivilegeread", sqlSessionTemplateRef = "dsprivilegereadSqlSessionTemplate")
public class DsPrivilegeReadConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dsprivilegeread")
    public DataSource dsprivilegereadDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory dsprivilegereadSqlSessionFactory(@Qualifier("dsprivilegereadDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/authorization/privilege/mapper/dsprivilegeread/*.xml"));
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager dsprivilegereadTransactionManager(@Qualifier("dsprivilegereadDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate dsprivilegereadSqlSessionTemplate(@Qualifier("dsprivilegereadSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}

