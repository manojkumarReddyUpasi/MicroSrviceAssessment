package com.service1.microservice.share;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response;
import feign.codec.ErrorDecoder;


@Component
public class FeignErrorDecoder implements ErrorDecoder {
	
	Environment environment;
	
	@Autowired
	public FeignErrorDecoder(Environment environment)
	{
		this.environment = environment;
	}

	public FeignErrorDecoder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Exception decode(String methodKey, Response response) {
		switch (response.status()) {
		case 400:
			// Do something
			// return new BadRequestException();
			break;
		case 404: {
			if (methodKey.contains("notFoundService2")) {
				return new ResponseStatusException(HttpStatus.valueOf(response.status()), environment.getProperty("notfound.exception"));
			}
			break;
		}
		default:
			return new Exception(response.reason());
		}
		return null;
	}

}

