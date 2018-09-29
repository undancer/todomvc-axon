package com.undancer.app.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/foo")
public class FooController {

    @GetMapping
    public ResponseEntity get() {
        System.out.println("foo");
        Map<String, Object> body = new HashMap<>();
        return ResponseEntity.ok(body);
    }

}
