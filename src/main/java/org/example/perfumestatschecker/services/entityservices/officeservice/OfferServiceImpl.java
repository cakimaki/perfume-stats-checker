package org.example.perfumestatschecker.services.entityservices.officeservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.Offer;
import org.example.perfumestatschecker.models.Perfume;
import org.example.perfumestatschecker.repositories.OfferRepository;
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
			// Existing offer found, update its information
			offer = existingOfferOpt.get();
			updateOfferFromDto(offer, dto);
		} else {
			// No existing offer found, create a new one
			offer = new Offer();
			offer.setPerfume(perfume);
			updateOfferFromDto(offer, dto);
		}
		
		return offer;
	}
	private void updateOfferFromDto(Offer offer, FilteredPerfumeDto dto) {
		offer.setOfferUrl(dto.getUrl());
		offer.setInStock((dto.getStock()));
		offer.setSite(dto.getSite());
	}
}
