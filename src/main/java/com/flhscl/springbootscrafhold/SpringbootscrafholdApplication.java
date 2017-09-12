package com.flhscl.springbootscrafhold;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @author <a href="http://flcoder.com">cl</a>
 * @version 1.0 & 2017/6/26
 * @since 1.0
 */
@SpringBootApplication
@Slf4j
@EnableCaching
public class SpringbootscrafholdApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(SpringbootscrafholdApplication.class, args);
	}

}
