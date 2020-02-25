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
    public ResponseEntity findTimecardByUserId(@PathVariable("id") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTimecardByUserId(userId));
    }

    @GetMapping("/projects/{id}/timecards")
    @ResponseBody
    public ResponseEntity findTimeCardByProject(@PathVariable("id") String project,
                                                @RequestParam(required = false, value = "sub_project") String subProject) {
        List<Timecard> findingResultByProject = service.findTimecardByProject(project);
        if (findingResultByProject.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: project not exist");
        }
        if (subProject == null) {
            return ResponseEntity.status(HttpStatus.OK).body(findingResultByProject);
        }
        List<Timecard> findingResultBySubProject = service.findSubProjectFromFindingByProjectResult(findingResultByProject, subProject);
        return findingResultBySubProject.size() > 0 ? ResponseEntity.status(HttpStatus.OK).body(findingResultBySubProject)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: sub-project not exist");
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<List<String>> timeCardExceptionHandler(ConstraintViolationException e){
        List<String> exceptionList= new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {exceptionList.add(constraintViolation.getMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionList);
    }
}
