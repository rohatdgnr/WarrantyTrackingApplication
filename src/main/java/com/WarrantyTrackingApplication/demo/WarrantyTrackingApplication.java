package com.WarrantyTrackingApplication.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="WarrantyTracking",version = "1.0",description = "WTA"))
public class WarrantyTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WarrantyTrackingApplication.class, args);
	}

}
