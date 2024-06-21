package org.example.backendtestprojectforagencyamazon;

import org.springframework.boot.SpringApplication;

public class TestBackendTestProjectForAgencyAmazonApplication {

	public static void main(String[] args) {
		SpringApplication.from(BackendTestProjectForAgencyAmazonApplication::main).with(TestcontainersConfig.class).run(args);
	}

}
