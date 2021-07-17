package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.UserService;
import com.project.entities.Output;

@RestController
public class DataController {
	 @Autowired
	    private UserService userService;

	    @GetMapping("data/{value}")
	    public ResponseEntity<String> getBooks(@PathVariable("value") String value) {

	        String  output = userService.getFinalData(value);
	        if (output==null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	        return ResponseEntity.status(HttpStatus.CREATED).body(output);
	    }
}
