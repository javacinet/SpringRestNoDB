package net.javaci.springRestNoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringRestNoDBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestNoDBApplication.class, args);
	}

}
