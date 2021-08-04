package com.zhan.server.registry.consul.configuration;

import com.zhan.server.registry.consul.RegistrationCustomizer;
import org.springframework.cloud.consul.serviceregistry.ConsulRegistrationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author zhanzhan
 * @Date 2021/8/4 9:07
 */
@Configuration
public class ConsulAutoConfiguration {

    @Bean
    public ConsulRegistrationCustomizer consulRegistrationCustomizer() {
        return new RegistrationCustomizer();
    }
}
