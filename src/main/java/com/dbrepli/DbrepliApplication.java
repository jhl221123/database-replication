package com.dbrepli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.dbrepli.config.DataSourceConfig;

// @Import(DataSourceConfig.class)
@SpringBootApplication
public class DbrepliApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbrepliApplication.class, args);
	}

}
