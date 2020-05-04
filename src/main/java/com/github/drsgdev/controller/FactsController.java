package com.github.drsgdev.controller;

import java.util.List;
import java.util.Optional;

import com.github.drsgdev.model.Facts;
import com.github.drsgdev.service.FactsService;
import com.github.drsgdev.util.ResponseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/facts")
public class FactsController {

  @Autowired
  private FactsService factsService;

  @GetMapping("/all")
  public ResponseEntity<List<Facts>> findAll() {
    return ResponseEntity.ok(factsService.findAll());
  }

  @GetMapping("/find")
  public ResponseEntity<Facts> findById(@RequestParam int id) {
    Optional<Facts> Facts = factsService.findById(id);

    return ResponseService.res(Facts);
  }

  @PostMapping("/add")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<String> addFacts(@RequestBody Facts Facts) {
    factsService.save(Facts);

    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/delete")
  public ResponseEntity<Facts> deleteById(@RequestParam int id) {
    Optional<Facts> deletedFacts = factsService.deleteById(id);

    return ResponseService.res(deletedFacts);
  }

  @DeleteMapping("/delete/json")
  public ResponseEntity<Facts> delete(@RequestBody Facts Facts) {
    Optional<Facts> deletedFacts = factsService.delete(Facts);

    return ResponseService.res(deletedFacts);
  }

  @PutMapping("/replace")
  public ResponseEntity<Facts> replaceFacts(@RequestParam int id, @RequestBody Facts Facts) {
    Optional<Facts> replacedFacts = factsService.replace(id, Facts);

    return ResponseService.res(replacedFacts);
  }

  @PatchMapping("/modify")
  public ResponseEntity<Facts> modifyFacts(@RequestParam int id, @RequestBody Facts Facts) {
    return replaceFacts(id, Facts);
  }
}
