package com.service2.microservice;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.service2.microservice.entity.Test;
import com.service2.microservice.repository.TestRepository;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class Service2Application {

	@Autowired
	private TestRepository testRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Service2Application.class, args);
	}
	
	
	@Bean
	InitializingBean sendDatabase() {
	    return () -> {
	    	
	    	testRepository.save(new Test(1,0,"Warrior","red"));
	    	testRepository.save(new Test(2,0,"Wizard","green"));
	    	testRepository.save(new Test(3,0,"Priest","white"));
	    	testRepository.save(new Test(4,0,"Rogue","yellow"));
	    
	    	testRepository.save(new Test(5,1,"Fighter","blue"));
	    	testRepository.save(new Test(6,1,"Paladin","lighblue"));
	    	testRepository.save(new Test(7,1,"Ranger","lighgreen"));
	    	
	    	testRepository.save(new Test(8,2,"Mage","grey"));
	    	testRepository.save(new Test(9,2,"Specialist wizard","lightgrey"));
	    	testRepository.save(new Test(10,3,"Cleric","red"));
	    	testRepository.save(new Test(11,3,"Druid","green"));
	    	testRepository.save(new Test(12,3,"Priest of specific mythos","white"));
	    	testRepository.save(new Test(13,4,"Thief","yellow"));
	    	testRepository.save(new Test(14,4,"Bard","blue"));
	    	testRepository.save(new Test(15,13,"Assassin","lighblue"));
	    	
	    	
	    			
	    	
	    	
	        
	      };
	   }
	}


