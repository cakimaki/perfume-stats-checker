package org.example.perfumestatschecker.services.entityservices.offerservice.priceservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.Price;
import org.springframework.transaction.annotation.Transactional;

public interface PriceService {
	
	@Transactional
	Price createOrUpdate(FilteredPerfumeDto dto, Offer offer);
	//Price createOrUpdatePrice(Offer offer, FilteredPerfumeDto dto);
}
