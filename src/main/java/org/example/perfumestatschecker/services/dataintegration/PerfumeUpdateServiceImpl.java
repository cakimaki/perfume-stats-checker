package org.example.perfumestatschecker.services.dataintegration;

import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.repositories.offer.OfferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PerfumeUpdateServiceImpl implements PerfumeUpdateService {
	private final OfferRepository offerRepository;
	
	private final PerfumeDataProcessingPipelineService processingPipelineService;
	private static final Logger logger = LoggerFactory.getLogger(PerfumeUpdateServiceImpl.class);
	@Autowired
	public PerfumeUpdateServiceImpl(OfferRepository offerRepository, PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService) {
		this.offerRepository = offerRepository;
		this.processingPipelineService = perfumeDataProcessingPipelineService;
		
	}
	
	@Override
	public void resetAllPerfumes(){
		Set<String> uniqueUrls = offerRepository.findAll().stream()
				.map(Offer::getOfferUrl)
				.collect(Collectors.toSet());
		
	
		int counter = 0;
		for(String url : uniqueUrls){
			try{
				processingPipelineService.processAndSavePerfumeDataFromUrl(url);
				counter++;
			}catch(Exception e){
				System.out.printf("Error processing URL: " + url + ". Error: " + e.getMessage());
			}
		}
		
		logger.info("Processed {} urls.", counter);
		
	}
	
}
