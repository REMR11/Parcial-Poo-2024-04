package com.parcialpoo.ufg.MR100823;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.parcialpoo.ufg.MR100823")
public class Mr100823Application {

	public static void main(String[] args) {
		SpringApplication.run(Mr100823Application.class, args);
		ConsoleApp.initConsoleApp(args);
	}

}
