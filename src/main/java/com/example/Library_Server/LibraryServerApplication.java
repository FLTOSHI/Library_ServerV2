package com.example.Library_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class LibraryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServerApplication.class, args);
	}

}
