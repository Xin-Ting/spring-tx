package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 85217
 */
@Configuration
public class MybatisConfig {
    private static final String TYPE_ALIASES_PACKAGE = "org.example.domain";
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(@Autowired DruidDataSource druidDataSource) {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(druidDataSource);
        //起别名
        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        return sqlSessionFactoryBean;
    }

    private static final String DAO_PACKAGE = "org.example.dal";
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage(DAO_PACKAGE);
        return mapperScannerConfigurer;
    }
}
