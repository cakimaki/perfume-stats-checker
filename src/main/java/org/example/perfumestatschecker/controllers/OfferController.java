package org.example.perfumestatschecker.controllers;

import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.services.entityservices.offerservice.offerservice.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	public ResponseEntity<List<OfferProjectionDto>> getAllOffersDetails(){
		List<OfferProjectionDto> offerProjectionDtos = offerService.getOfferDetails();
		return ResponseEntity.ok(offerProjectionDtos);
	}
	
	@GetMapping("bybrand/{brand}")
	public ResponseEntity<List<OfferProjectionDto>> getAllOffersByBrand(@PathVariable String brand){
		List<OfferProjectionDto> offerProjectionDtos = offerService.getOffersByBrand(brand);
		return ResponseEntity.ok(offerProjectionDtos);
	}
	
	@GetMapping("byperfume/{perfumeId}")
	public ResponseEntity<List<OfferProjectionDto>> getOfferDetailsForPerfume(@PathVariable Long perfumeId){
		List<OfferProjectionDto> offerProjectionDtos = offerService.getPerfumeOffersById(perfumeId);
		return ResponseEntity.ok(offerProjectionDtos);
	}
	
}
