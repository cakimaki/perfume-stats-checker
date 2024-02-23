package org.example.perfumestatschecker.services.dataintegration;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParserSelector;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;
import org.example.perfumestatschecker.services.dataintegration.webdriver.WebContentFetcher;
import org.example.perfumestatschecker.services.dataintegration.storingdata.PerfumeDataSavingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfumeDataProcessingPipelineServiceImpl implements PerfumeDataProcessingPipelineService{
	private final WebContentFetcher webContentFetcher;
	private final DataParserSelector dataParserSelector;
	private final PerfumeDataSavingService perfumeDataSavingService;

	@Autowired
	public PerfumeDataProcessingPipelineServiceImpl(WebContentFetcher webContentFetcher, DataParserSelector dataParserSelector, PerfumeDataSavingService perfumeDataSavingService) {
		this.webContentFetcher = webContentFetcher;
		this.dataParserSelector = dataParserSelector;
		this.perfumeDataSavingService = perfumeDataSavingService;
	}
	
	@Transactional
	@Override
	public void processAndSavePerfumeDataFromUrl(String url){
		String jsonResponse = webContentFetcher.fetchJsonFromUrl(url);
		
		DataParsingStrategy strategy = dataParserSelector.selectStrategy(url);
		
		List<FilteredPerfumeDto> dtos = strategy.parseDataStringIntoObject(jsonResponse);
		
		perfumeDataSavingService.persistFilteredPerfumeData(dtos);
	}
}