package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.services.entityservices.offerservice.offerservice.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/offer")
public class OfferController {
	
	private final OfferService offerService;
	
	@Autowired
	public OfferController(OfferService offerService) {
		this.offerService = offerService;
	}
	
	@GetMapping()
	public ResponseEntity<List<OfferProjectionDto>> getOfferDetails(){
		List<OfferProjectionDto> offerProjectionDtos = offerService.getOfferDetails();
		return ResponseEntity.ok(offerProjectionDtos);
	}
	
}
