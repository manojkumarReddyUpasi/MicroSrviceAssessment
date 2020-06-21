package com.service2.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service2.microservice.service.TestService;

@RestController
@RequestMapping("/service2")
public class Service2Controller {
	@Autowired
	TestService testService; 

	@GetMapping()
	public ResponseEntity<?>  service2()
	{
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}
 
	@GetMapping(value="/associate",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?>  Associate(@RequestParam(required = true) int id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(testService.getAssociate(id));
	}
}
