package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.services.TimecardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimecardController {
    private TimecardService service;

    public TimecardController(TimecardService service) {
        this.service = service;
    }

    @PostMapping("/timecards")
    @ResponseBody
    public ResponseEntity addTimeCard(@Valid @RequestBody Timecard timeCard) {
        service.addTimeCard(timeCard);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @GetMapping("/user/{id}/timecards")
    @ResponseBody
    public ResponseEntity<List<Timecard>> findTimecardByUserId(@PathVariable("id") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTimecardByUserId(userId));
    }

    @GetMapping("/project/{id}/timecards")
    @ResponseBody
    public ResponseEntity<List<Timecard>> findTimeCardByProject(@PathVariable("id") String projectName){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTimecardByProject(projectName));
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<List<String>> timeCardExceptionHandler(ConstraintViolationException e){
        List<String> res = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {res.add(constraintViolation.getMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
