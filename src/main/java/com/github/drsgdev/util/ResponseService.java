package com.github.drsgdev.util;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class ResponseService {
  public static <T> ResponseEntity<T> res(Optional<T> entity) {
    if (entity.isPresent()) {
      return ResponseEntity.ok(entity.get());
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }
}
