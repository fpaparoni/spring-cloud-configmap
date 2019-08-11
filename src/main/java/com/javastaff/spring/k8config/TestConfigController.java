package com.javastaff.spring.k8config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigController {
	
	@Autowired
	private Config config;
	
	@Value("${single.property}") 
	private String singleProperty;
	
    @GetMapping
    public String load() {
    	StringBuilder sb=new StringBuilder();
    	sb.append("single.property : ")
    	  .append(singleProperty)
    	  .append(" ----- ")
    	  .append("config: ")
    	  .append(config.toString());
        return sb.toString();
    }
}