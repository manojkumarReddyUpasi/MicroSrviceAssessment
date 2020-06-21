package com.service1.microservice.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service1.microservice.FeignClient.FeginClientService3;
import com.service1.microservice.FeignClient.FeignClientService;
import com.service1.microservice.dto.ConcatenatedDTO;
import com.service1.microservice.service.Service1AppService;

@Service
public class Service1AppServiceImpl implements Service1AppService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	FeignClientService feignClientService;
	@Autowired
	FeginClientService3 feginClientService3;

	@Override
	public String getService() {
		logger.info("Before calling service2");
		String serviceReturn = feignClientService.service2();
		logger.info("After calling service2");

		logger.info("Before calling service3");
		ConcatenatedDTO concatenated = feginClientService3.service3();
		logger.info("After calling service3");
		logger.info("The json " + concatenated);

		return String.join(" ", serviceReturn, concatenated.getName(), concatenated.getSurname());
	}

	@Override
	public Object getServiceNotFound() {
		
		return feignClientService.notFoundService2();
	}

}
