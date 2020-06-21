package com.service1.microservice.FeignClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import com.service1.microservice.dto.ConcatenatedDTO;

import feign.FeignException;
import feign.hystrix.FallbackFactory;

@FeignClient(name = "service3")
public interface FeginClientService3 {
	@PostMapping("/service3")
	public ConcatenatedDTO service3();

}


@Component
class Service3FallbackFactory implements FallbackFactory<FeginClientService3> {

	@Override
	public FeginClientService3 create(Throwable cause) {
		// TODO Auto-generated method stub
		return new AlbumsService3ClientFallback(cause);
	}
}	
	class AlbumsService3ClientFallback implements FeginClientService3 {

		Logger logger = LoggerFactory.getLogger(this.getClass());

		private final Throwable cause;

		public AlbumsService3ClientFallback(Throwable cause) {
			this.cause = cause;
		}

	

		@Override
		public ConcatenatedDTO service3() {

			if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
				logger.error("404 error took place when service3 was called with  Error message: "
						+ cause.getLocalizedMessage());
			} else {
				logger.error("Other error took place: " + cause.getLocalizedMessage());
			}

			return new ConcatenatedDTO();
			
		}


		

	}

