package com.learning.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.pojo.HeartBeat;

/**
 * 
 * @author Vivek
 * Heart Beat API for sanity/ checking connectivity
 */
@RestController
public class HeartBeatController {
	
	@Autowired
	private HeartBeat heartBeat;
	
	@GetMapping("/heartBeat")
	public HeartBeat getHeartBeat() {
		return heartBeat;
	}

	@RequestMapping("/test")
	public String test() {
		return "OK";
	}

}
