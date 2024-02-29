package org.example.perfumestatschecker.services.dataintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfumeDataProcessingApproachesImpl implements PerfumeDataProcessingApproaches {
	private static final Logger logger = LoggerFactory.getLogger(PerfumeDataProcessingApproachesImpl.class);
	private final PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService;
	
	@Autowired
	public PerfumeDataProcessingApproachesImpl(PerfumeDataProcessingPipelineService perfumeDataProcessingPipelineService) {
		this.perfumeDataProcessingPipelineService = perfumeDataProcessingPipelineService;
	}
	
	@Override
	public void processListOfPerfumeUrls(List<String> urlRequests) {
		for (String urlRequest : urlRequests) {
			try {
				logger.info("Processing Url: {}",urlRequest);
				perfumeDataProcessingPipelineService.processAndSavePerfumeDataFromUrl(urlRequest);
			}catch(Exception e){
				logger.error("Error processing URL: {}", urlRequest, e.getMessage());
			}
		}
	}
/*
	@Override
	public*/
}