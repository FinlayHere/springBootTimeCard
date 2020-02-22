package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class TimeCardController {

    @PostMapping("/timecards")
    @ResponseBody
    public ResponseEntity<TimeCard> addTimeCard(@Valid @RequestBody TimeCard timeCard) {
        return ResponseEntity.status(HttpStatus.CREATED).body(timeCard);
    }
}
