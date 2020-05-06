package com.github.drsgdev.util;

import java.util.List;
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

  public static <T> ResponseEntity<List<T>> res(List<T> entity) {
    if (entity.isEmpty()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    } else {
      return ResponseEntity.ok(entity);
    }
  }
}
