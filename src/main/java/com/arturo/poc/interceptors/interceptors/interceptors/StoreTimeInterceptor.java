package com.arturo.poc.interceptors.interceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("storeTimeInterceptor")
public class StoreTimeInterceptor implements HandlerInterceptor {

  @Value("${store.aperture.hour}")
  private Integer storeOpenTime;

  @Value("${store.close.hour}")
  private Integer storeCloseTime;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);

    if(hour < storeOpenTime || hour > storeCloseTime) {
      response.getWriter().println("The store is close, please come back later");
      response.setContentType("application/json");
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return false;
    }
    response.getWriter().println("Welcome to the store");
    response.setContentType("application/json");
    response.setStatus(HttpServletResponse.SC_OK);
    return true;
  }


  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}
