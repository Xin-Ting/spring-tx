package org.example.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 85217
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
@ComponentScan("org.example")
@Import({DataSourceConfig.class,MybatisConfig.class})
@EnableTransactionManagement()
public class AopConfig {
}
