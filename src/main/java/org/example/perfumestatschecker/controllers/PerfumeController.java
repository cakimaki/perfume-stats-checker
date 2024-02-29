package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.PerfumeNameDto;
import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice.PerfumeNameService;
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
	private final PerfumeNameService perfumeNameService;
	@Autowired
	public PerfumeController(PerfumeService perfumeService, PerfumeNameService perfumeNameService){
		this.perfumeService = perfumeService;
		this.perfumeNameService = perfumeNameService;
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
	
	@GetMapping("/names")
	public ResponseEntity<?> getAllPerfumeNames(){
		try {
			List<PerfumeNameDto> perfumeNames =  perfumeNameService.getAllPerfumeNames();
			if(perfumeNames.isEmpty()){
				return ResponseEntity.ok().body("No perfumes to be found in db.");
			}
			return ResponseEntity.ok(perfumeNames);
		}catch(Exception e){
			return ResponseEntity.internalServerError().body("An error occured while fetching perfumes details: " + e.getMessage());
		}
	}
	
}
