/*
 * Copyright (c) 2023 Vincent Dao.
 */

package com.vincentdao.pimtoolback.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.vincentdao.pimtoolback.domain",
		"com.vincentdao.pimtoolback.application",
		"com.vincentdao.pimtoolback.infrastructure"
})
public class PimToolBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(PimToolBackApplication.class, args);
	}
}
