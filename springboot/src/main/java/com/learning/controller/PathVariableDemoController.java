package com.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableDemoController { 	

	@GetMapping("/pathVar/{pathVar}")
	public String echoPathVar(@PathVariable ("pathVar") String pathVariable) {		
		return String.format("Echo.... %s", pathVariable);
	}
}
