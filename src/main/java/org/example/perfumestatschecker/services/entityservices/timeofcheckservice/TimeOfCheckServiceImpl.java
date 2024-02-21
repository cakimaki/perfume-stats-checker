package org.example.perfumestatschecker.services.entityservices.timeofcheckservice;

import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.TimeOfCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.perfumestatschecker.repositories.offer.TimeCheckedRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class TimeOfCheckServiceImpl implements TimeOfCheckService {
	
	private final TimeCheckedRepository timeCheckedRepository;
	
	@Autowired
	public TimeOfCheckServiceImpl(TimeCheckedRepository timeCheckedRepository) {
		this.timeCheckedRepository = timeCheckedRepository;
	}
	
	
	@Transactional
	@Override
	public TimeOfCheck recordTimeOfCheck(OfferStatus offerStatus){
		TimeOfCheck timeOfCheck = new TimeOfCheck();
		timeOfCheck.setOfferStatus(offerStatus);
		timeOfCheck.setTime(LocalDateTime.now());
		return timeCheckedRepository.save(timeOfCheck);
	}
}