package org.example.perfumestatschecker.services.entityservices.offerservice.offerservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeVariant;
import org.example.perfumestatschecker.repositories.offer.OfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
	
	private final OfferRepository offerRepository;
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	@Transactional
	@Override
	public Offer createOrUpdateOffer(FilteredPerfumeDto dto, PerfumeVariant perfumeVariant) {
		
		Optional<Offer> existingOfferOpt = offerRepository.findByPerfumeVariantAndSiteAndOfferUrl(perfumeVariant, dto.getSite(), dto.getUrl());
		
		Offer offer;
		if (existingOfferOpt.isPresent()) {
			return existingOfferOpt.get();
		} else {
			offer = new Offer();
			offer.setPerfumeVariant(perfumeVariant);
			offer.setOfferUrl(dto.getUrl());
			offer.setSite(dto.getSite());
			offer.setImageUrl(dto.getUrlToImage());
		}
		
		return offerRepository.save(offer);
	}
	
	@Override
	public List<OfferProjectionDto> getOfferDetails(){
		return offerRepository.findOfferDetailsWithLastStatus();
	}
	
	@Override
	public List<OfferProjectionDto> getPerfumeOffersById(Long perfumeId){
		return offerRepository.findOfferDetailsByPerfumeId(perfumeId);
	}
}
