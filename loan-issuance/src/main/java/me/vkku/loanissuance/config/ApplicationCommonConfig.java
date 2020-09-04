package me.vkku.loanissuance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationCommonConfig {


    @Bean
    @Primary
    @Autowired
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    @Autowired
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate(){
        return new RestTemplate();
    }

}
