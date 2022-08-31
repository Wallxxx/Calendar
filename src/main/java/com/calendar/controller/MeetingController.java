package com.calendar.controller;

import com.calendar.model.MeetingEntity;
import com.calendar.services.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping(value = "/new")
    public ResponseEntity<MeetingEntity> new_meeting(@RequestBody MeetingEntity meeting) {
        return new ResponseEntity<>(meetingService.save(meeting), HttpStatus.OK);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<MeetingEntity> delete_meeting(@RequestBody MeetingEntity meeting) {
        return new ResponseEntity<>(meetingService.delete(meeting), HttpStatus.OK);
    }

    @PostMapping(value = "/clear")
    public ResponseEntity<String> clear() {
        try {
            meetingService.clear();
        } catch (Exception e) {
            return new ResponseEntity<>("Не получилось выполнить отчистку. Стек ошибки: \n" + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Отчистка выполнена успешно. ", HttpStatus.OK);
    }

    @GetMapping(value = "/getMeetingsByDate")
    public ResponseEntity<List<MeetingEntity>> getMeetingsByDate(@RequestBody String date) {
        return new ResponseEntity<>(meetingService.getMeetingsByDate(date), HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam("name") String name) {
        String hello = "Hello, " + name;
        return new ResponseEntity<>(hello, HttpStatus.OK);
    }
}
