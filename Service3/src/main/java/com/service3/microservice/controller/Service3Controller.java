package com.service3.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service3.microservice.service.Service3ApplicationService;

@RestController
@RequestMapping("/service3")
public class Service3Controller {

	@Autowired
	Service3ApplicationService service3ApplicationService;
	@PostMapping()
	public  ResponseEntity<?> serviceUp()
	{
		return ResponseEntity.status(HttpStatus.OK).body(service3ApplicationService.service3());
	}
 
}
