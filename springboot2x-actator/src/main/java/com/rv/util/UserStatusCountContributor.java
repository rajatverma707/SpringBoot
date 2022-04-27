package com.rv.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.rv.repository.UserRepository;

@Component
public class UserStatusCountContributor implements InfoContributor {

	@Autowired
	UserRepository repository;
	
	@Override
	public void contribute(Builder builder) {
		Map<String,Long> countHashMap= new HashMap<>();
		countHashMap.put("active", repository.getUserStatusCount("active"));
		countHashMap.put("inActive", repository.getUserStatusCount("active"));
		countHashMap.put("blocked", repository.getUserStatusCount("blocked"));
		builder.withDetail("userStatus", countHashMap);
	}
	
	
	
	
	
	
	

}
