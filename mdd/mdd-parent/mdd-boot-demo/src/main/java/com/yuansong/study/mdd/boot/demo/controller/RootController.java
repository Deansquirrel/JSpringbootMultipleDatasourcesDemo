package com.yuansong.study.mdd.boot.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags= {"01 Root"})
@RequestMapping("/")
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@ApiOperation("路径测试")
	@GetMapping("/")
	public String root() {
		logger.info("root");
		return "Root";
	}
	
	@ApiOperation("路径测试")
	@GetMapping("/hello")
	public String hello() {
		logger.info("hello");
		return "Hello";
	}

}
