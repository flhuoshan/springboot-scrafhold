package com.flhscl.springbootscrafhold.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.flhscl.springbootscrafhold.config.AppConfig;
/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/cmd")
public class CmdController {

	@Autowired
	private AppConfig appConfig;

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public JSONObject ping() {
		return new JSONObject().fluentPut("status", "OK").fluentPut("timestamp", new Date().getTime());
	}

	@RequestMapping(value = "/env", method = RequestMethod.GET)
	public JSONObject env() {
		return new JSONObject().fluentPut("env", appConfig.getEnv()).fluentPut("isTest", appConfig.isTest())
				.fluentPut("isPre", appConfig.isPre()).fluentPut("isPrd", appConfig.isPrd());
	}

}
