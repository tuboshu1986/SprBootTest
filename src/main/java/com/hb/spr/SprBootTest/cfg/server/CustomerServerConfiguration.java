package com.hb.spr.SprBootTest.cfg.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomerServerConfiguration implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    private static final Logger log = LoggerFactory.getLogger(CustomerServerConfiguration.class);
    
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        log.info(">>>>设置错误页面");
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,"/error.html"));
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error.html"));
    }

}
