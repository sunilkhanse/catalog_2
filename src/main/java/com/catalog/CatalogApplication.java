package com.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatalogApplication {

    private static final Logger log = LoggerFactory.getLogger(CatalogApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CatalogApplication.class, args);
        log.info("--- Started catalog application ---");
	}

}
