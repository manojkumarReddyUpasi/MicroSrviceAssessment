package com.service1.microservice.FeignClient;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "service2",fallbackFactory = Service2FallbackFactory.class)
public interface FeignClientService {
	@GetMapping("/service2")
	public String service2();
	@GetMapping("/service2/not-found")
	public Object notFoundService2();

}

@Component
class Service2FallbackFactory implements FallbackFactory<FeignClientService> {

	@Override
	public FeignClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new AlbumsServiceClientFallback(cause);
	}
}	
	class AlbumsServiceClientFallback implements FeignClientService {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		private final Throwable cause;

		public AlbumsServiceClientFallback(Throwable cause) {
			this.cause = cause;
		}

	

		@Override
		public String service2() {

			if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
				logger.error("404 error took place when service2 was called with  Error message: "
						+ cause.getLocalizedMessage());
			} else {
				logger.error("Other error took place: " + cause.getLocalizedMessage());
			}

			return "";
			
		}

		@Override
		public Object notFoundService2() {

			if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
				logger.error("404 error took place when notFoundService2 was called with  Error message: "
						+ cause.getLocalizedMessage());
			} else {
				logger.error("Other error took place: " + cause.getLocalizedMessage());
			}

			return "";
		}

	}

