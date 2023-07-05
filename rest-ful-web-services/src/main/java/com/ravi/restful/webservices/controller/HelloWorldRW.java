package com.ravi.restful.webservices.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ravi.restful.webservices.model.HelloWrold;

@RestController
public class HelloWorldRW {

	MessageSource messageSource;

	public HelloWorldRW(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

//	@RequestMapping(method=RequestMethod.GET,path="/helloworld")
//	public String getHelloWorldMessage() {
//		return "Hello World";
//	}

//	@GetMapping(path="/helloworld")
//	public String getHelloWorldMessage() {
//		return "Hello World";
//	}

	@GetMapping(path = "/helloworld")
	public HelloWrold getHelloWorldMessage() {
		return new HelloWrold("Hello World");
	}

	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWrold getHelloWorldWithPathVariable(@PathVariable String name) {
		return new HelloWrold(String.format("Hello World, %s", name));
	}

	@GetMapping(path = "/hello-i18")
	public String getI18Message() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default message", locale);
	}
}
