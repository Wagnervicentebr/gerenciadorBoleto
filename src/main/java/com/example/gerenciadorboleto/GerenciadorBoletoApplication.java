package com.example.gerenciadorboleto;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class GerenciadorBoletoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorBoletoApplication.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

}
