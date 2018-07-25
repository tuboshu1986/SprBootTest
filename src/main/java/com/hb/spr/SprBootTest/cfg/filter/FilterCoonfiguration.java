package com.hb.spr.SprBootTest.cfg.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterCoonfiguration {
    
    @Bean
    public FilterRegistrationBean<RequestInfoFilter> filterRegistrationBean(){
        FilterRegistrationBean<RequestInfoFilter> filterregistration = new FilterRegistrationBean<>();
        filterregistration.setFilter(new RequestInfoFilter());
        filterregistration.addUrlPatterns("/*");
        return filterregistration;
    }
}
