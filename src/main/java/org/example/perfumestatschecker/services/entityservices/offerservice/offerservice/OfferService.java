package org.example.perfumestatschecker.services.entityservices.offerservice.offerservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OfferService {
	
	@Transactional
	Offer createOrUpdateOffer(FilteredPerfumeDto dto, Perfume perfume);
	
	List<OfferProjectionDto> getOfferDetails();
	
	List<OfferProjectionDto> getPerfumeOffersById(Long perfumeId);
}
