package com.arturo.poc.interceptors.interceptors.controller;

import com.arturo.poc.interceptors.interceptors.model.StoreMessage;
import java.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

  @GetMapping("/attend")
  public ResponseEntity<StoreMessage>getStore () {
    return ResponseEntity.ok(new StoreMessage(LocalDateTime.now(), "StoreController", null));
  }

}
