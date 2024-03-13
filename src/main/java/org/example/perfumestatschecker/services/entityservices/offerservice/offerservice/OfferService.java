package org.example.perfumestatschecker.services.entityservices.offerservice.offerservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.Site;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeVariant;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OfferService {
	@Transactional
	Offer createOrUpdateOffer(FilteredPerfumeDto dto, PerfumeVariant perfumeVariant, Site site);
	
	List<OfferProjectionDto> getOfferDetails();
	
	List<OfferProjectionDto> getOffersByBrand(String brand);
	
	List<OfferProjectionDto> getPerfumeOffersById(Long perfumeId);
}
