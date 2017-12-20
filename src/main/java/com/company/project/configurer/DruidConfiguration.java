package com.company.project.configurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * descrition：
 *
 * @author: ZHZ
 * @create: 2017/12/20
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public WallConfig wallConfig(){
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        return wallConfig;
    }

    @Bean
    public WallFilter wallFilter(WallConfig wallConfig){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return  wallFilter;
    }


}
