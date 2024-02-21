package org.example.perfumestatschecker.services.entityservices.offerstatusservice;


import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.models.offer.StockStatus;
import org.example.perfumestatschecker.repositories.offer.OfferStatusRepository;
import org.example.perfumestatschecker.services.entityservices.timeofcheckservice.TimeOfCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OfferStatusServiceImpl implements OfferStatusService {
	private final OfferStatusRepository offerStatusRepository;
	
	private final TimeOfCheckService timeOfCheckService;
	
	@Autowired
	public OfferStatusServiceImpl(OfferStatusRepository offerStatusRepository, TimeOfCheckService timeOfCheckService) {
		this.offerStatusRepository = offerStatusRepository;
		this.timeOfCheckService = timeOfCheckService;
	}
	
	@Transactional
	@Override
	public OfferStatus findOrCreateOfferStatus(Offer offer, Price price, StockStatus stockStatus){
		OfferStatus offerStatus = offerStatusRepository.findByOfferAndPriceAndStock(offer, price, stockStatus)
				.orElseGet(() -> {
					OfferStatus newStatus = new OfferStatus();
					newStatus.setOffer(offer);
					newStatus.setPrice(price);
					newStatus.setStockStatus(stockStatus);
					return offerStatusRepository.save(newStatus);
				});
		
		timeOfCheckService.recordTimeOfCheck(offerStatus);
		return offerStatus;
	}
	
	/*@Transactional
	public OfferStatus updateOfferStatus()*/
}
