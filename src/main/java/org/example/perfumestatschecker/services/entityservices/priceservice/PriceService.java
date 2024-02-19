package org.example.perfumestatschecker.services.entityservices.priceservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.Offer;
import org.example.perfumestatschecker.models.Price;

public interface PriceService {
	Price createOrUpdatePrice(Offer offer, FilteredPerfumeDto dto);
}
