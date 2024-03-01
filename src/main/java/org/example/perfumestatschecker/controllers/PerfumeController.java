package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.PerfumeDto;
import org.example.perfumestatschecker.dtos.getdtos.PerfumeVariantDetailsDto;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice.PerfumeService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice.PerfumeVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
public class PerfumeController {
	private final PerfumeVariantService perfumeVariantService;
	private final PerfumeService perfumeService;
	@Autowired
	public PerfumeController(PerfumeVariantService perfumeVariantService, PerfumeService perfumeService){
		this.perfumeVariantService = perfumeVariantService;
		this.perfumeService = perfumeService;
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllPerfumes(){
		try {
			List<PerfumeVariantDetailsDto> perfumes =  perfumeVariantService.getAllPerfumeVariantsDetails();
			if(perfumes.isEmpty()){
				return ResponseEntity.ok().body("No perfumes to be found in db.");
			}
			return ResponseEntity.ok(perfumes);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("An error occured while fetching perfumes details: " + e.getMessage());
		}
	}
	
	@GetMapping("/names")
	public ResponseEntity<?> getAllPerfumeNames(){
		try {
			List<PerfumeDto> perfumeNames =  perfumeService.getAllPerfumeNames();
			if(perfumeNames.isEmpty()){
				return ResponseEntity.ok().body("No perfumes to be found in db.");
			}
			return ResponseEntity.ok(perfumeNames);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("An error occured while fetching perfumes details: " + e.getMessage());
		}
	}
	
}
