package com.arturo.poc.interceptors.interceptors.interceptors;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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
    int actualHour = calendar.get(Calendar.HOUR_OF_DAY);
//abro 1 y cierro 12
    if(actualHour < storeOpenTime || actualHour > storeCloseTime) {
      ObjectMapper objectMapper = new ObjectMapper();
      Map<String,String> responseJson = new HashMap<>();
      responseJson.put("message", "The store is close, please come back later");
      responseJson.put("time", LocalDateTime.now().toString());
      responseJson.put("error", "Store is close");
      String storeIsClose = objectMapper.writeValueAsString(responseJson);
      response.getWriter().println(storeIsClose);
      response.setContentType("application/json");
      response.setStatus(HttpServletResponse.SC_FORBIDDEN);
      return false;
    }
    request.setAttribute("message", "Welcome to the store at " + LocalDateTime.now());
    return true;
  }


  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }
}
