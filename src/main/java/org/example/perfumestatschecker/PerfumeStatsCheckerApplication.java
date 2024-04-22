package org.example.perfumestatschecker;

import org.example.perfumestatschecker.services.dataintegration.sitebots.another.FetchPerfumesByBrand;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class PerfumeStatsCheckerApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(PerfumeStatsCheckerApplication.class, args);
	}
	
	public void run(String... args) throws Exception {

	
	}
}
