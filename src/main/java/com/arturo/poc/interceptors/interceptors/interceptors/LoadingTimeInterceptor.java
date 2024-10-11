package com.arturo.poc.interceptors.interceptors.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
@Qualifier("timeInterceptor")
public class LoadingTimeInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(LoadingTimeInterceptor.class);

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    //Para poder ver que metodo se esta llamando utilizamos el ojeto handler
    logger.info("Loading time: postHandle()  saliendo ...{}", ((HandlerMethod) handler).getMethod()
        .getName());
    long endTime = System.currentTimeMillis();
    long startTime = (long) request.getAttribute("startTime");
    long loadingTime = endTime - startTime;
    logger.info("Loading time: {} ms", loadingTime);
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    logger.info("Loading time: preHandle()  entrando ... {}", ((HandlerMethod) handler).getMethod()
        .getName());
    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);
    Random random = new Random();
    int delay = random.nextInt(500);
    Thread.sleep(delay);

    //As we evaluate  the request, we could also modify the response.
//    Map<String,String> responseJson = new HashMap<>();
//    responseJson.put("ErrorCode","You are not authorized to access this resource");
//    responseJson.put("Date", LocalDateTime.now().toString());
//
//    //convert the responseJson to a json string
//    ObjectMapper objectMapper = new ObjectMapper();
//    String message = objectMapper.writeValueAsString(responseJson);
//    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//    response.getWriter().write(message);
//    response.setContentType("application/json");

    // And if all these things are done, we must return false to indicate that request has not been handle completely
    //return false;

    return true;
  }


}
