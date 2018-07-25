package com.hb.spr.SprBootTest.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取Spring上下文
 * 
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }
    
    public static ApplicationContext getApplicationContext(){
        return SpringUtils.applicationContext;
    }
    
    public static <T> T getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }

}
