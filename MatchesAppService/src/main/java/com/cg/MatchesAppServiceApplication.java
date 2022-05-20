package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan({"com.cg.service.MatchesService","com.cg.controller.MatchesController"})
public class MatchesAppServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MatchesAppServiceApplication.class, args);
	}

}
