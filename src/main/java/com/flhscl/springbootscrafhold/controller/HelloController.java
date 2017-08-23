package com.flhscl.springbootscrafhold.controller;

import com.flhscl.springbootscrafhold.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0 To change this template use File | Settings | Editor | File and
 *        Code Templates Description:
 */
@Controller
public class HelloController {


	@Autowired
	private AppConfig appConfig;

	@RequestMapping("/")
	public String index(ModelMap map) {
		map.addAttribute("content", "This application is running in " + appConfig.getEnv() + " Mode");
		return "welcome";
	}
}
