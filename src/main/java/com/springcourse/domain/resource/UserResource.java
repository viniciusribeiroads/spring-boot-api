package com.springcourse.domain.resource;

import com.springcourse.domain.entity.Request;
import com.springcourse.domain.entity.User;
import com.springcourse.domain.resource.dto.UserLoginDto;
import com.springcourse.domain.service.RequestService;
import com.springcourse.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UserResource {
    private UserService userService;
    private RequestService requestService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user) {
        User createdUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        User updatedUser = userService.update(user);
        return ResponseEntity.ok().body(updatedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getBy(@PathVariable Long id){
        User user = userService.getById(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserLoginDto userLoginDto){
        User loggedUser = userService.login(userLoginDto.getEmail(), userLoginDto.getPassword());
        if (loggedUser != null){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(loggedUser);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @GetMapping("/{id}/requests")
    public ResponseEntity<List<Request>> listAllRequests(@PathVariable(name = "id") Long id){
        List<Request> requests = requestService.listAllByOwnerId(id);
        return ResponseEntity.ok(requests);
    }





}
