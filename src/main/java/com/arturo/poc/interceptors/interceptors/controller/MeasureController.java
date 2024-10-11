package com.arturo.poc.interceptors.interceptors.controller;

import java.util.Collection;
import java.util.Collections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
public class MeasureController {

  @GetMapping("/foo")
  public Map<String, String> foo() {
    return Map.of("message", "handle foo del controlador");
  }

  @GetMapping("/bar")
  public Map<String, String> bar() {
    return Collections.singletonMap("message", "handle bar del controlador");
  }

  @GetMapping("/baz")
  public Map<String, String> baz() {
    return Collections.singletonMap("message", "handle baz del controlador");
  }
}
