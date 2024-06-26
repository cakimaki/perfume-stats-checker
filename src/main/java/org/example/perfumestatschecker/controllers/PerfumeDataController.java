package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.UrlRequest;
import org.example.perfumestatschecker.services.dataintegration.PerfumeDataProcessingApproaches;
import org.example.perfumestatschecker.services.dataintegration.PerfumeDataProcessingPipelineService;
import org.example.perfumestatschecker.services.dataintegration.PerfumeUpdateService;
import org.example.perfumestatschecker.services.dataintegration.sitebots.another.FetchPerfumesByBrand;
import org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand.FetchUrlsSelector;
import org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand.FetchUrlsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/perfume")
public class PerfumeDataController {
	//private final FetchPerfumesByBrand fetchPerfumesByBrand;
	private final PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService;
	private final PerfumeDataProcessingApproaches perfumeDataProcessingApproaches;
	private final PerfumeUpdateService perfumeUpdateService;
	private final FetchUrlsSelector fetchUrlsSelector;
	@Autowired
	public PerfumeDataController(FetchPerfumesByBrand fetchPerfumesByBrand, PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService, PerfumeDataProcessingApproaches perfumeDataProcessingApproaches, PerfumeUpdateService perfumeUpdateService, FetchUrlsSelector fetchUrlsSelector){
		//this.fetchPerfumesByBrand = fetchPerfumesByBrand;
		this.perfumeDataProcessingPipelineService = perfumeDataProcessingPipelineService;
		this.perfumeDataProcessingApproaches = perfumeDataProcessingApproaches;
		this.perfumeUpdateService = perfumeUpdateService;
		this.fetchUrlsSelector = fetchUrlsSelector;
	}

	@PostMapping()
	public ResponseEntity<String> createPerfumeData(@RequestBody UrlRequest urlRequest){
		try{
			perfumeDataProcessingPipelineService.processAndSavePerfumeDataFromUrl(urlRequest.getUrl());
			
			return ResponseEntity.ok("Data persisted successfully for URL:" + urlRequest.getUrl());
		
		}catch (Exception e){
			e.printStackTrace();
			
			return ResponseEntity.internalServerError().body("Failed to persist data for URL: " + urlRequest.getUrl());
		}
	}
	
	@PostMapping("/multiple")
	public ResponseEntity<String> createMultiplePerfumeData(@RequestBody List<UrlRequest> urlRequests){
		try{
			List<String> urls = urlRequests.stream().map(UrlRequest::getUrl).collect(Collectors.toList());
			perfumeDataProcessingApproaches.processListOfPerfumeUrls(urls);
			return ResponseEntity.ok("Data persisted successfully for URLs.");
			
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Failed to persist data for URLs");
		}
	}
	
	@PostMapping("/douglas/urlsByBrand")
	public ResponseEntity<String> processPerfumesByBrandName(@RequestBody UrlRequest urlRequest) {
		try {
			FetchUrlsStrategy strategySelected = fetchUrlsSelector.selectStrategy(urlRequest.getSite());
			List<String> urls = strategySelected.fetchPerfumeUrlsByBrand(urlRequest.getBrand());
			System.out.println("Number of urls to be fetched :" + urls.size() + " (this message is from controller).");
			perfumeDataProcessingApproaches.processListOfPerfumeUrls(urls);
			return ResponseEntity.ok("Data has been fetched...");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Failed to persist the data...");
		}
	}
	/**
	 * Endpoint to reset and update all perfumes based on unique URLs from offers.
	 * This operation fetches all offer URLs, eliminates duplicates, and re-processes each unique URL.
	 *
	 * @return ResponseEntity with operation result.
	 */
	@PutMapping("/reset")
	public ResponseEntity<String> updateAllExistingOffers() {
		try{
			perfumeUpdateService.resetAllPerfumes();
			return ResponseEntity.ok("All perfume offers has been updated.");
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.internalServerError().body("Error updating the offers.");
		}
	}


}

