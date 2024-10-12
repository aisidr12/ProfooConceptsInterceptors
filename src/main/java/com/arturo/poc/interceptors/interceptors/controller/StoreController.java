package com.arturo.poc.interceptors.interceptors.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

  @GetMapping("/attend")
  public ResponseEntity<?>getStore (HttpServletRequest request) {
    Map<String,String> map = new HashMap<>();
    map.put("title", "Welcome to the store");
    map.put("time", LocalDateTime.now().toString());
    map.put("message", request.getAttribute("message").toString());
    return ResponseEntity.ok(map);
  }

}
