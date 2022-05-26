package com.springcourse.domain.resource;

import com.springcourse.domain.entity.RequestStage;
import com.springcourse.domain.enums.RequestState;
import com.springcourse.domain.service.RequestService;
import com.springcourse.domain.service.RequestStageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/request-stages")
public class RequestStageResource {

    private RequestStageService requestStageService;


    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage){
        return ResponseEntity.status(HttpStatus.CREATED).body(requestStageService.save(requestStage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getBy(@PathVariable Long id){
        return ResponseEntity.ok().body(requestStageService.getBy(id));
    }



}
