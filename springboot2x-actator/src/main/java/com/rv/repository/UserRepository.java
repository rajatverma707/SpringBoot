package com.rv.repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;
import com.rv.model.User;

@Repository
public class UserRepository {
	
	public List<User> getAllUser(){
		return Stream.of(
				new User(101,"Virat","v@i.in","active"),
				new User(102,"Jack","jack@i.in","Blocked"),
				new User(103,"Rammy","v@i.in","active"),
				new User(104,"Dorsey","v@i.in","inActive"),
				new User(105,"Sanju","v@i.in","inActive")	
				).collect(Collectors.toList());
	}
	
	public long getUserStatusCount(String status) {
	    return	getAllUser().stream().filter(u-> u.getStatus().equalsIgnoreCase(status)).count();
	}

}
