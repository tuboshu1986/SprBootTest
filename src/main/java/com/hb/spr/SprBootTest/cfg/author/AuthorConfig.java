package com.hb.spr.SprBootTest.cfg.author;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix="system.author", name="name")
@ConditionalOnClass({AuthorProperties.class, AuthorInfo.class})
public class AuthorConfig {
    
    @Bean
    //@ConditionalOnClass(AuthorProperties.class)
    public AuthorInfo authorInfo(AuthorProperties authorProp) {
        System.out.println(">>>>创建AuthorInfo");
        AuthorInfo info  = new AuthorInfo();
        info.setName(authorProp.getName());
        info.setRemarks(authorProp.getRemarks());
        return info;
    }
    
}
