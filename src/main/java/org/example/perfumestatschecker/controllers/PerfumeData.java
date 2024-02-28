package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.UrlRequest;
import org.example.perfumestatschecker.services.dataintegration.PerfumeDataProcessingPipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;
@RestController
@RequestMapping("/perfume")
public class PerfumeData {

	private final PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService;
	
	@Autowired
	public PerfumeData(PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService){
		this.perfumeDataProcessingPipelineService = perfumeDataProcessingPipelineService;
	}

	@PostMapping()
	public ResponseEntity<String> createPerfumeData(@RequestBody UrlRequest urlRequest){
		try{
			long startTime = (System.currentTimeMillis());
			perfumeDataProcessingPipelineService.processAndSavePerfumeDataFromUrl(urlRequest.getUrl());
			long executionTime = (System.currentTimeMillis() - startTime);
			
			return ResponseEntity.ok("Ex time - "+ executionTime +".Data persisted successfully for URL:" + urlRequest.getUrl());
		
		}catch (Exception e){
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().body("Failed to persist data for URL: " + urlRequest.getUrl());
		}
	}
	



}

