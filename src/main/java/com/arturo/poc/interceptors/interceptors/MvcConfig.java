package com.arturo.poc.interceptors.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    private final HandlerInterceptor timeInterceptor;

    public MvcConfig(HandlerInterceptor timeInterceptor) {
        this.timeInterceptor = timeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor).addPathPatterns("/app/bar","/app/foo");
        //In case we want to add a path pattern we could use the following line;
        // .addPathPatterns("/app/foo","/app/**")
        //In case we want to exclude some path pattern we could use the following line;
        // .excludePathPatterns("/posts/**")
    }


}
