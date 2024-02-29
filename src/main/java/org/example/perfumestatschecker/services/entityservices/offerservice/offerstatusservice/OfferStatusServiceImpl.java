package org.example.perfumestatschecker.services.entityservices.offerservice.offerstatusservice;


import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.models.offer.StockStatus;
import org.example.perfumestatschecker.repositories.offer.OfferStatusRepository;
import org.example.perfumestatschecker.services.entityservices.offerservice.timeofcheckservice.TimeOfCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
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
		//get offerstatus by offer price stockstatus
		Optional<OfferStatus> offerStatusOpt = offerStatusRepository.findByOfferAndPriceAndStock(offer, price, stockStatus);
		
		OfferStatus returnOfferStatus;
		if (offerStatusOpt.isPresent()) {
			//if found assign to returning value
			returnOfferStatus = offerStatusOpt.get();
			returnOfferStatus.setLastTimeOfCheck(LocalDateTime.now());
		} else {
			// if not, first update lastStatuses for the offer
			updateLastStatuses(offer);
			
			// Then create a new OfferStatus
			OfferStatus newStatus = new OfferStatus();
			
			newStatus.setFirstTimeOfCheck(LocalDateTime.now());
			newStatus.setOffer(offer);
			newStatus.setPrice(price);
			newStatus.setStockStatus(stockStatus);
			newStatus.setLastTimeOfCheck(LocalDateTime.now());
			newStatus.setLastStatus(true); // This is now the latest status
			
			//assign saved status to return value
			returnOfferStatus = offerStatusRepository.save(newStatus);
		}
		// Record a time check for the new status
		timeOfCheckService.recordTimeOfCheck(returnOfferStatus);
		
		return returnOfferStatus;
	}
	
	//updates all the previous statuses
	public void updateLastStatuses(Offer offer){
		List<OfferStatus> previousStatuses = offerStatusRepository.findAllByOfferAndLastStatusTrue(offer);
						
		for (OfferStatus offerStatus : previousStatuses){
			offerStatus.setLastStatus(false);
		}
		offerStatusRepository.saveAll(previousStatuses);
	}
}
