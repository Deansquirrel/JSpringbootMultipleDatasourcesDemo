package com.yuansong.study.mdd.boot.jtoolstest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuansong.tools.secret.ZillionWSDA;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
@Api(tags= {"01 Root"})
public class RootController {
	
	private static final Logger logger = LoggerFactory.getLogger(RootController.class);
	
	@GetMapping("hello")
	@ApiOperation("路径测试")
	public String hello() {
		logger.debug("hello");
		return "hello";
	}
	
	@GetMapping("secret")
	@ApiOperation("secret调用测试")
	public String secret() {
		logger.debug("========================================");
		logger.debug("secret");
		ZillionWSDA z = new ZillionWSDA();
		String d = z.DecryptFromBase64Format("cipherText", "key");
		logger.debug("d: " + d);
		String e = z.EncryptToBase64Format("plainText", "key");
		logger.debug("e: " + e);
		logger.debug("========================================");
		return "OK";
	}

}
