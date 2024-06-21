package org.example.backendtestprojectforagencyamazon;

import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.utility.MountableFile;

//@TestConfiguration(proxyBeanMethods = false)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers

@Slf4j
public class TestcontainersConfiguration {

//	@Bean
//	@ServiceConnection
//	MySQLContainer<?> mysqlContainer() {
//		return new MySQLContainer<>(DockerImageName.parse("mysql:latest"))
//				.withCopyFileToContainer(MountableFile.forClasspathResource("testData.sql"),
//						"/docker-entrypoint-initdb.d/");
//	}

	@Container
	static MySQLContainer<?> mysqlContainer =
			new MySQLContainer<>("mysql:latest")
					.withCopyFileToContainer(MountableFile.forClasspathResource("testData.sql"),
							"/docker-entrypoint-initdb.d/");


	@DynamicPropertySource
	public static void setProperties(DynamicPropertyRegistry registry) {

		log.info("id------" + mysqlContainer.getContainerId());
		log.info("url------" + mysqlContainer.getJdbcUrl());
		log.info("username------" +mysqlContainer.getUsername());
		log.info("password------" + mysqlContainer.getPassword());
		Startables.deepStart(mysqlContainer);
		registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl);
		registry.add("spring.datasource.username", mysqlContainer::getUsername);
		registry.add("spring.datasource.password",mysqlContainer::getPassword);

	}

}
