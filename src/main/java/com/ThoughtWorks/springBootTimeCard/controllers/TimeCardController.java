package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.services.TimeCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TimeCardController {
    private TimeCardService service;

    public TimeCardController(TimeCardService service) {
        this.service = service;
    }

    @PostMapping("/timecards")
    @ResponseBody
    public ResponseEntity<String> addTimeCard(@Valid @RequestBody TimeCard timeCard) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addTimeCard(timeCard));
    }
}
