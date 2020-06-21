package com.service2.microservice.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service2.microservice.dto.InnerDto;
import com.service2.microservice.dto.Pair;
import com.service2.microservice.dto.ResponseDTO;
import com.service2.microservice.dto.SubClassDTO;
import com.service2.microservice.entity.Test;
import com.service2.microservice.repository.TestRepository;
import com.service2.microservice.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	TestRepository testRepository;

	@Override
	public Set<ResponseDTO> getAssociate(int id) {
		List<Test> response = testRepository.findAll();
		List<Test> lisPush = new ArrayList<Test>();
		Set<ResponseDTO> resp = new HashSet<ResponseDTO>();
		response.forEach(i -> {
			if (i.getParentId() == id) {
				lisPush.add(i);
			}
		});
		response.forEach(j -> {
			lisPush.forEach(k -> {
				if (j.getParentId() == k.getChildId()) {
					ResponseDTO responseDTO = new ResponseDTO();
					responseDTO.setName(k.getName());
					Set<SubClassDTO> subClass = new HashSet<SubClassDTO>();
					response.forEach(l -> {
						if (l.getParentId() == k.getChildId()) {
							SubClassDTO subClassDTO = new SubClassDTO();
							subClassDTO.setName(l.getName());
							subClass.add(subClassDTO);
						}
					});
					subClass.forEach(m -> {
						response.forEach(n -> {
							if (n.getName() == m.getName()) {
								response.forEach(o -> {
									if (n.getChildId() == o.getParentId()) {
										Set<InnerDto> sub = new HashSet<>();
										response.forEach(p -> {
											if (o.getParentId() == p.getChildId()) {
												InnerDto subdto = new InnerDto();
												subdto.setName(o.getName());
												sub.add(subdto);
											}
										});
										m.setSubClass(sub);
									}
								});
							}
						});
					});
					responseDTO.setSubClasses(subClass);
					resp.add(responseDTO);
				}
			});
		});
		return resp;
	}

}
