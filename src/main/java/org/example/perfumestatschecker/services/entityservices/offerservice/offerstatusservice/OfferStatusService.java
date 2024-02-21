package org.example.perfumestatschecker.services.entityservices.offerservice.offerstatusservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.models.offer.StockStatus;
import org.springframework.transaction.annotation.Transactional;

public interface OfferStatusService {
	
	@Transactional
	OfferStatus findOrCreateOfferStatus(Offer offer, Price price, StockStatus stockStatus);
}
