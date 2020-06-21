package com.service1.microservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service1.microservice.service.Service1AppService;

@RestController
@RequestMapping("api/v1/service1")
public class ServiceController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Service1AppService service1AppService;
	
	@GetMapping()
	public String serviceUp()
	{
		return "Service Up ";
	}
	
	@GetMapping("/not-found")
	public ResponseEntity<?>  serviceNotFound()
	{
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(service1AppService.getServiceNotFound());
	}
	@PostMapping
	public ResponseEntity<?> concatenated(){
		String concatResponse=service1AppService.getService();
		logger.info("Concatenated Response {"+ concatResponse+"}");
		return ResponseEntity.status(HttpStatus.OK).body(concatResponse);
	}
 
}
