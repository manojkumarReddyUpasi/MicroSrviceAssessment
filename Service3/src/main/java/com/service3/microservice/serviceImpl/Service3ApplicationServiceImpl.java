package com.service3.microservice.serviceImpl;

import org.springframework.stereotype.Service;

import com.service3.microservice.dto.ConcatenatedDTO;
import com.service3.microservice.service.Service3ApplicationService;
@Service
public class Service3ApplicationServiceImpl  implements Service3ApplicationService{

	@Override
	public ConcatenatedDTO service3() {
		ConcatenatedDTO concatenated=new ConcatenatedDTO();
		concatenated.setName("John");
		concatenated.setSurname("Doe");
		return concatenated;
	}

}
