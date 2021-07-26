package com.epam.mishin.service;

import com.epam.mishin.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/users")
    public ResponseEntity<User> root(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
