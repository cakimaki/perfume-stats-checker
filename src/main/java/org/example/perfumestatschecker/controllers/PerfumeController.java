package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/perfumes")
public class PerfumeController {
	private final PerfumeService perfumeService;
	
	@Autowired
	public PerfumeController(PerfumeService perfumeService){
		this.perfumeService = perfumeService;
	}
	
	@GetMapping()
	public ResponseEntity<?> getAllPerfumes(){
		try {
			List<PerfumeDetailsDto> perfumes =  perfumeService.getAllPerfumesDetails();
			if(perfumes.isEmpty()){
				return ResponseEntity.ok().body("No perfumes to be found in db.");
			}
			return ResponseEntity.ok(perfumes);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("An error occured while fetching perfumes details: " + e.getMessage());
		}
	}
	
	
	
}
