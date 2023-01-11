package com.learning.springboot.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * Configuration for response to heartbeat call to the application.
 * 
 * @author Vivek Birdi
 * Do not change!
 */
@ConfigurationProperties(prefix = "env-config")
@Component
public class HeartBeat{

	
	/** To include Date-Time in response
	 */
	private final String dateTime = LocalDateTime.now().toString();
	
	/**
	 * To include status in response
	 */
	private String status = "OK";
	
	/**
	 * To include environment info in response
	 */
	private String env;

	public String getDateTime() {
		return dateTime;
	}

	public String getStatus() {
		return status;
	}

	public String getEnv() {
		return env;
	}

	public void setEnv(String env) {
		this.env = env;
	}
	
}
