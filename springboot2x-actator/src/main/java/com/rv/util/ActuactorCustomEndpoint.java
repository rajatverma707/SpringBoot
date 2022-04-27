package com.rv.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "release-note")
public class ActuactorCustomEndpoint {
	
	Map<String,List<String>> releasenotesMap= new  HashMap<>();
	
	@PostConstruct
	public void initNotes() {
		releasenotesMap.put("version-1.0", Arrays.asList("Enhanced booking facilities","Added Invetory"));
		releasenotesMap.put("version-1.1", Arrays.asList("Intgrated payment API","Actuator endpoint added"));
	}
	
	
	
	@ReadOperation
	public Map<String,List<String>> getReleaseNote() {
		return releasenotesMap;
	}

	@ReadOperation
	public List<String> getReleaseNoteByVersion(@Selector String version){
		return releasenotesMap.get(version);
	}
	
	@WriteOperation
	public String addReleaseNotes(@Selector String version,String releaseNotes) {
		releasenotesMap.put(version, Arrays.stream(releaseNotes.split(",")).collect(Collectors.toList()));
		return "200";
	}
	
	@DeleteOperation
	public String deleteReleaseNotes(@Selector String version) {
		releasenotesMap.remove(version);
		return "204";
	}
	
	
	
}
