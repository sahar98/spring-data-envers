package com.sajaya.backend.SJA;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.config.EnableEnversRepositories;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@EnableWebMvc
@EnableJpaRepositories(basePackages = {"com.sajaya.*"}, repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@ComponentScan(basePackages = {"com.sajaya"})
@SpringBootApplication
@EntityScan({"com.sajaya.*"})
@OpenAPIDefinition(servers = {@Server(url = "${swagger.server.url}")})
@EnableJpaAuditing
@EnableEnversRepositories
public class SjaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SjaApplication.class, args);
	}

}
