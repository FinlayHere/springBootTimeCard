package com.ThoughtWorks.springBootTimeCard.controllers;

import com.ThoughtWorks.springBootTimeCard.models.Timecard;
import com.ThoughtWorks.springBootTimeCard.services.TimecardService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.*;

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

    @GetMapping("/timecards/{id}")
    @ResponseBody
    public ResponseEntity findTimecardBy(@PathVariable Integer id) {

        return ResponseEntity.ok(service.findTimeCardById(id));
    }

    @GetMapping("/timecards")
    @ResponseBody
    public ResponseEntity findAllTimecards(){
        return ResponseEntity.ok(service.findAllTimecards());
    }


    @GetMapping("/users/{id}/timecards")
    @ResponseBody
    public ResponseEntity findTimecardByUserId(@PathVariable("id") String userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.findTimecardByUserId(userId));
    }

    @GetMapping("/projects/{id}/timecards")
    @ResponseBody
    public ResponseEntity findTimeCardByProject(@PathVariable("id") String project,
                                                @RequestParam(required = false, value = "sub_project") String subProject) {
        //TODO: 这里有很多判断，JAVA Optional可以了解一下，虽然这里可以不用Optional
        List<Timecard> findingResultByProject = service.findTimecardByProject(project);
        if (findingResultByProject.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: project not exist");
        }
        //XXX: 不知道此处Optional使用的方法对不对
        if (!Optional.ofNullable(subProject).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(findingResultByProject);
        }
        List<Timecard> findingResultBySubProject = service.findTimecardDetailBySubProjectForm(findingResultByProject, subProject);

        return findingResultBySubProject.size() > 0 ? ResponseEntity.status(HttpStatus.OK).body(findingResultBySubProject)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: sub-project not exist");
    }

    @PutMapping("/timecards/{id}")
    @ResponseBody()
    public ResponseEntity updateTimecard(@PathVariable("id") Integer id, @RequestBody Timecard timecard) throws Exception {
        service.updateTimecard(id,timecard);

        return ResponseEntity.accepted().body(null);
    }

    @DeleteMapping("/timecards/{id}")
    @ResponseBody
    public ResponseEntity deleteTimecardBy(@PathVariable("id") int id) {
        service.deleteBy(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @DeleteMapping("/timecard-details/{id}")
    @ResponseBody
    public ResponseEntity deleteTimecardDetailBy(@PathVariable("id") int id) {
        service.deleteTimecardDetailBy(id);

        return ResponseEntity.accepted().body(null);
    }

    @ExceptionHandler({javax.validation.ConstraintViolationException.class})
    @ResponseBody
    public ResponseEntity<List<String>> timeCardExceptionHandler(ConstraintViolationException e){
        List<String> exceptionList= new ArrayList<>();
        e.getConstraintViolations().forEach(constraintViolation -> {exceptionList.add(constraintViolation.getMessage());});

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionList);
    }

    @ExceptionHandler({org.springframework.dao.EmptyResultDataAccessException.class})
    @ResponseBody
    public ResponseEntity dataNotExistExceptionHandler(EmptyResultDataAccessException e) {
        String errorMessage = "Id " + e.getLocalizedMessage().substring(76).replace(" exists!"," not exists!");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }

    @ExceptionHandler({java.lang.Exception.class})
    @ResponseBody
    public ResponseEntity timecardNotExistHandler(Exception e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({org.springframework.web.bind.MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseEntity workTimeConstrainHandler(MethodArgumentNotValidException e){
        Set<String> errors = new HashSet<>();
        e.getBindingResult().getAllErrors().forEach(objectError -> errors.add(objectError.getDefaultMessage()));

        return ResponseEntity.badRequest().body(errors);
    }

}
