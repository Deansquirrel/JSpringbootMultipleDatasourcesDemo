package com.yuansong.study.mdd.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "datasource.default")
@Configuration
public class DataSourceConfigDefault extends DataSourceConfigAbstract {

}
