package com.service2.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service2.microservice.entity.Test;

public interface TestRepository  extends JpaRepository<Test,Long>{

}
