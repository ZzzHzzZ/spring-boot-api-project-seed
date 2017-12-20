package com.company.project.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 */
@Configuration
public class DataSourceConfiguration {
    Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Bean
    @Primary
    public DruidDataSource dataSource() {
        logger.info("-------------德鲁伊数据源开始设置监控---------------");
        DruidDataSource druidDataSource = new DruidDataSource();
        logger.info("-------------德鲁伊数据源配置成功-------------------");
        return druidDataSource;
    }
}
