package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.models.TimecardDetail;
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

    @GetMapping("/projects/{id}/timecards")
    @ResponseBody
    public ResponseEntity findTimeCardByProject(@PathVariable("id") String projectName,
                                                                @RequestParam(required = false) String sub_project){
        List<Timecard> findingResultByProjectName = new ArrayList<>();
        findingResultByProjectName = service.findTimecardByProject(projectName);

        if (findingResultByProjectName.size()==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: project not exist");
        }
        else if (sub_project==null){
            return ResponseEntity.status(HttpStatus.OK).body(findingResultByProjectName);
        }
        else {
            List<Timecard> findingResultBySubProject = new ArrayList<>();
            for (Timecard timecard:findingResultByProjectName){
                for (TimecardDetail timecardDetail:timecard.getTimecardDetails()){
                   if (timecardDetail.getSubProject().equals(sub_project)) {
                       findingResultBySubProject.add(timecard);
                       break;
                   }
                }
            }
            if (findingResultBySubProject.size()!=0){
                return ResponseEntity.status(HttpStatus.OK).body(findingResultBySubProject);
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: sub-project not exist");
            }
        }
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<List<String>> timeCardExceptionHandler(ConstraintViolationException e){
        List<String>  exceptionList= new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {exceptionList.add(constraintViolation.getMessage());});
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionList);
    }
}
