package com.jd.excalibur.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Description:
 * <p>
 * Author: wujiyu
 * Date:2018-07-21 15:17
 */
@Configuration
public class CreateAdminInterceptors extends WebMvcConfigurerAdapter{

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 页面内容初始化拦截器
        registry.addInterceptor(logoutInterceptor())
                .excludePathPatterns("/Logging")
                .addPathPatterns("/**","/**/**");
    }

    @Bean
    public LogoutInterceptor logoutInterceptor(){
        return new LogoutInterceptor();
    }
}
