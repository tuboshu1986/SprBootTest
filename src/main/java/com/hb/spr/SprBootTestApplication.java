package com.hb.spr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 入口
 */
@SpringBootApplication
public class SprBootTestApplication extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SprBootTestApplication.class);
    }
	
	public static void main(String[] args){
        SpringApplication.run(SprBootTestApplication.class, args);
    }
}
