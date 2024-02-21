package org.example.perfumestatschecker.services.entityservices.timeofcheckservice;

import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.TimeOfCheck;
import org.springframework.transaction.annotation.Transactional;

public interface TimeOfCheckService {
	@Transactional
	TimeOfCheck recordTimeOfCheck(OfferStatus offerStatus);
}
