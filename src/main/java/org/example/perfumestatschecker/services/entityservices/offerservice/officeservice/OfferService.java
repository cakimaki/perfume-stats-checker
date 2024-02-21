package org.example.perfumestatschecker.services.entityservices.offerservice.officeservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.transaction.annotation.Transactional;

public interface OfferService {
	
	@Transactional
	Offer createOrUpdateOffer(FilteredPerfumeDto dto, Perfume perfume);
}
