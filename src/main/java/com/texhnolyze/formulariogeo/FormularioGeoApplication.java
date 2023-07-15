package com.texhnolyze.formulariogeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FormularioGeoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormularioGeoApplication.class, args);
	}

}
