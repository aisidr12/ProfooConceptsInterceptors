package com.arturo.poc.interceptors.interceptors.model;

import java.time.LocalDateTime;

public record StoreMessage(LocalDateTime time, String message, String error) {

}
