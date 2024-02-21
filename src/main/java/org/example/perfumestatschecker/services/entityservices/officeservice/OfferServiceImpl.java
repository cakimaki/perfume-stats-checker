package org.example.perfumestatschecker.services.entityservices.officeservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.repositories.offer.OfferRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
	
	private final OfferRepository offerRepository;
	
	public OfferServiceImpl(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}
	
	@Transactional
	@Override
	public Offer createOrUpdateOffer(FilteredPerfumeDto dto, Perfume perfume) {
		
		Optional<Offer> existingOfferOpt = offerRepository.findByPerfumeAndSiteAndOfferUrl(perfume, dto.getSite(), dto.getUrl());
		
		Offer offer;
		if (existingOfferOpt.isPresent()) {
			return existingOfferOpt.get();
		} else {
			offer = new Offer();
			offer.setPerfume(perfume);
			offer.setOfferUrl(dto.getUrl());
			offer.setSite(dto.getSite());
			offer.setImageUrl(dto.getUrlToImage());
		}
		
		return offerRepository.save(offer);
	}
}
