package com.javastaff.spring.k8config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Configuration
@ConfigurationProperties(prefix = "myconfig")
@Data @AllArgsConstructor @NoArgsConstructor
public class Config implements Serializable{

	private static final long serialVersionUID = -8900976432592584351L;
	private String properties1;
	private String properties2;
	private SubConfig subconfig;
}