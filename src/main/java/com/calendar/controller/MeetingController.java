package com.calendar.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class MeetingController {

    //TODO: добавить репозиторий

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        String hello = "Hello, " + name;
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
