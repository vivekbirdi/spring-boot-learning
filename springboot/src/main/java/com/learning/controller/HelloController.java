package com.learning.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	private MessageSource messageSource;
	
	public HelloController(MessageSource messageSource) {
		this.messageSource =  messageSource;
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/greetNewYear")
	public String newYearGreeting() {
		Locale locale =  LocaleContextHolder.getLocale();
		return messageSource.getMessage("new.year.greeting", null, "Happy New Year All", locale);
	
	}
}
