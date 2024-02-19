package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.UrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/json")
public class JsonProcessingController {
	
	/*@PostMapping("/processJson")
	public ResponseEntity<String> processJsonFromUrl(@RequestBody UrlRequest urlRequest) {
		try {
			jsonProcessingService.processJsonFromUrl(urlRequest.getUrl());
			return ResponseEntity.ok("JSON processed successfully.");
		} catch (Exception e) {
			return ResponseEntity.internalServerError().body("Error processing JSON: " + e.getMessage());
		}
	}*/
}
