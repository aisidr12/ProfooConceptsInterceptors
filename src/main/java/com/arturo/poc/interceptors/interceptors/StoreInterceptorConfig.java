package com.arturo.poc.interceptors.interceptors;

import com.arturo.poc.interceptors.interceptors.interceptors.StoreTimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StoreInterceptorConfig implements WebMvcConfigurer {

  private final StoreTimeInterceptor storeTimeInterceptor;

  public StoreInterceptorConfig( StoreTimeInterceptor storeTimeInterceptor) {
    this.storeTimeInterceptor = storeTimeInterceptor;
  }


  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(storeTimeInterceptor).addPathPatterns("/store/attend");
  }
}
