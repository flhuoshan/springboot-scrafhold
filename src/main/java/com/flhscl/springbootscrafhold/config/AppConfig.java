package com.flhscl.springbootscrafhold.config;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
@Configuration
public class AppConfig {
	public static final String ENV_TEST = "test";
	public static final String ENV_PRE = "pre";
	public static final String ENV_PRD = "prd";

	@Value("${spring.profiles.active}")
	private String env;

	/**
	 * 是否是TEST环境
	 * 
	 * @return
	 */
	public boolean isTest() {
		return Objects.equals(env, ENV_TEST);
	}

	/**
	 * 是否是PRE环境
	 * 
	 * @return
	 */
	public boolean isPre() {
		return Objects.equals(env, ENV_PRE);
	}

	/**
	 * 是否是PRD环境
	 * 
	 * @return
	 */
	public boolean isPrd() {
		return Objects.equals(env, ENV_PRD);
	}

	public String getEnv() {
		return env;
	}

}
