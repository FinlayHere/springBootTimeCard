package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.TimeCard;
import com.ThoughtWorks.springBootTimeCard.models.TimeCardDetail;
import com.ThoughtWorks.springBootTimeCard.repositories.TimeCardRepository;
import com.ThoughtWorks.springBootTimeCard.repositories.TimecardDetailRepository;
import com.ThoughtWorks.springBootTimeCard.services.TimeCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    @GetMapping("/user/{id}/timecards")
    @ResponseBody
    public ResponseEntity<Collection<TimeCardDetail>> test(@PathVariable("id") String id){

        return ResponseEntity.status(HttpStatus.OK).body(service.searchTimeCardByUserId(id));
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<List<String>> timeCardExceptionHandler(ConstraintViolationException e){
        List<String> res = new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {res.add(constraintViolation.getMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
