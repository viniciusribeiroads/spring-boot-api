package com.springcourse.domain.resource;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.service.RequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/requests")
public class RequestResource {
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<Request> save(@RequestBody Request request){
        return ResponseEntity.status(HttpStatus.CREATED).body(requestService.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Request> update(@PathVariable Long id, @RequestBody Request request){
        request.setId(id);
        return ResponseEntity.ok().body(requestService.update(request));
    }

    @GetMapping
    public ResponseEntity<List<Request>> getAll(){
        return ResponseEntity.ok().body(requestService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Request> getBy(@PathVariable Long id){
        return ResponseEntity.ok().body(requestService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBy(@PathVariable Long id){
        if (requestService.deleteById(id)){
            return ResponseEntity.ok().body("Deleted with success!");
        }
        return ResponseEntity.notFound().build();


    }

}
