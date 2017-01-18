package com.codejava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}
	
	/*@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		String message = "Hello World, Spring 3.0!";
		return new ModelAndView("hello", "message", message);
	}
	*/
}