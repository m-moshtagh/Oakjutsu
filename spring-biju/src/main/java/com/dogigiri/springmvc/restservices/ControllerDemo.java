package com.dogigiri.springmvc.restservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/springbiju/v1/mvc/restservice")
public class ControllerDemo {
    // Dependant services

    // constructors for constructor injections

    @GetMapping("/{foo}")
    public ResponseEntity<Object> getFoo(@PathVariable("foo") Object foo) {
        // service call
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> saveFoo(@RequestBody Object foo) {
        // service call
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{foo}")
    public ResponseEntity<Object> updateFoo(@PathVariable("foo") Object foo, @RequestBody Object bar) {
        // service call
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{foo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFoo(@PathVariable("foo") Object foo) {
        // service call
    }
}
