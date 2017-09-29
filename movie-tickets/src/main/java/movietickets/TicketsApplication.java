package movietickets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import movietickets.application.InitialDatabase;

@SpringBootApplication
public class TicketsApplication //extends SpringBootServletInitializer {
{
	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);
	}
}
