package com.example.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author LinJie
 * @create 2020-12-17 8:25
 */
@Configuration
public class ShiroConfig {
    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);
        //拦截
        Map<String,String> filteMap = new LinkedHashMap<>();
        //授权
        filteMap.put("/product/*","perms[user:salesman]");
        filteMap.put("/user/*","perms[user:administrator]");
        filteMap.put("/selltable/*","perms[user:administrator]");
        filteMap.put("/product/*","authc");

        bean.setFilterChainDefinitionMap(filteMap);
        bean.setLoginUrl("/welcome");
        bean.setUnauthorizedUrl("/noauth");
        return bean;
    }

    //DafaultWebSecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecutiryManger(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        securityManager.setRememberMeManager(cookieRememberMeManager());
        return securityManager;
    }

    //创建realm对象，需要自定义类
    @Bean(name="userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }

    //整合ShiroDialect:用来整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialeact(){
        return new ShiroDialect();
    }
    /**
     * 1.配置Cookie对象
     * 记住我的cookie：rememberMe
     * @return  SimpleCookie rememberMeCookie
     */
    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //simpleCookie.setHttpOnly(true);
        //单位(秒)1天
        simpleCookie.setMaxAge(86400);
        return simpleCookie;
    }

    /**
     * 2.配置cookie管理对象
     * @return CookieRememberMeManager
     */
    @Bean
    public CookieRememberMeManager cookieRememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        System.out.println("【cookieRememberMeManager】"+cookieRememberMeManager);
        return cookieRememberMeManager;
    }
}
