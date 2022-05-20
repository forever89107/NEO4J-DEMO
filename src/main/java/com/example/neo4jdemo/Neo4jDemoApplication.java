package com.example.neo4jdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example.neo4jdemo")
@EnableSwagger2
public class Neo4jDemoApplication {
    private static final Logger LOG = LoggerFactory.getLogger(Neo4jDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Neo4jDemoApplication.class, args);
        LOG.info("Neo4jDemoApplication 啟動成功");
    }

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.example.neo4jdemo")).build();
    }

}
