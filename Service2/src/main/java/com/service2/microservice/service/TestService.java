package com.service2.microservice.service;

import java.util.List;
import java.util.Set;

import com.service2.microservice.dto.MegaMenuDTO;
import com.service2.microservice.dto.Pair;
import com.service2.microservice.dto.ResponseDTO;
import com.service2.microservice.entity.Test;

public interface TestService {
	Set<ResponseDTO> getAssociate(int id);
}
