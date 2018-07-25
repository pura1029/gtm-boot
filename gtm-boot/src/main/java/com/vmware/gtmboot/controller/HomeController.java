package com.vmware.gtmboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value="/api")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, value = "/hello")
	@ApiOperation(value= "/hello", httpMethod= "GET", notes="Hello Spring Boot")
	public String home() {
		return "GTM Spring Boot Home!";
	}

}
