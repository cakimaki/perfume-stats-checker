package org.example.perfumestatschecker.services.entityservices.officeservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.entityDto.OfferDto;
import org.example.perfumestatschecker.models.Offer;
import org.example.perfumestatschecker.models.Perfume;
import org.springframework.transaction.annotation.Transactional;

public interface OfferService {
	
	@Transactional
	Offer createOrUpdateOffer(FilteredPerfumeDto dto, Perfume perfume);
}
