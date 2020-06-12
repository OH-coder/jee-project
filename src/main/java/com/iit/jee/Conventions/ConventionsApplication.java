package com.iit.jee.Conventions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;

@SpringBootApplication
public class ConventionsApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConventionsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {



	}
}
