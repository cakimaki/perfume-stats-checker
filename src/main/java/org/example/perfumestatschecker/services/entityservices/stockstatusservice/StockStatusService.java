package org.example.perfumestatschecker.services.entityservices.stockstatusservice;

import org.example.perfumestatschecker.models.offer.StockStatus;
import org.springframework.transaction.annotation.Transactional;

public interface StockStatusService {
	@Transactional
	StockStatus findOrCreate(String stockStatusName);
}
