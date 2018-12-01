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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author duxuebo
 * @date 2018/12/1
 * @description 权限系统写数据源配置类(主)
 */

@Configuration
@MapperScan(basePackages = "com.authorization.privilege.mapper.dsprivilegewrite", sqlSessionTemplateRef = "dsprivilegewriteSqlSessionTemplate")
public class DsPrivilegeWriteConfig {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.dsprivilegewrite")
    @Primary
    public DataSource dsprivilegewriteDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public SqlSessionFactory dsprivilegewriteSqlSessionFactory(@Qualifier("dsprivilegewriteDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/authorization/privilege/mapper/dsprivilegewrite/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager dsprivilegewriteTransactionManager(@Qualifier("dsprivilegewriteDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionTemplate dsprivilegewriteSqlSessionTemplate(@Qualifier("dsprivilegewriteSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
