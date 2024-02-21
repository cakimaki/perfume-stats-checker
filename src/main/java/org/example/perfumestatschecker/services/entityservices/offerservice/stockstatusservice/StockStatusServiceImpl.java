package org.example.perfumestatschecker.services.entityservices.offerservice.stockstatusservice;

import org.example.perfumestatschecker.models.offer.StockStatus;
import org.example.perfumestatschecker.repositories.offer.StockStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StockStatusServiceImpl implements StockStatusService{
	
	private final StockStatusRepository stockStatusRepository;
	
	@Autowired
	public StockStatusServiceImpl(StockStatusRepository stockStatusRepository){
		this.stockStatusRepository = stockStatusRepository;
	}
	
	@Transactional
	@Override
	public StockStatus findOrCreate(String stockStatusName) {
		Optional<StockStatus> stockStatusOpt = stockStatusRepository.findByName(stockStatusName);
		
		if(stockStatusOpt.isPresent()){
			return stockStatusOpt.get();
		}else{
			StockStatus stockStatus = new StockStatus();
			stockStatus.setName(stockStatusName);
			return stockStatusRepository.save(stockStatus);
		}
	}
}
