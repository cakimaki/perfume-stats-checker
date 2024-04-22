package org.example.perfumestatschecker.services.dataintegration;

import org.apache.logging.log4j.LogManager;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParserSelector;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;

import org.example.perfumestatschecker.services.dataintegration.webdriver.oldServices.WebContentFetcher;
import org.example.perfumestatschecker.services.dataintegration.storingdata.PerfumeDataSavingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PerfumeDataProcessingPipelineServiceImpl implements PerfumeDataProcessingPipelineService{
	private final WebContentFetcher webContentFetcher;
	private final DataParserSelector dataParserSelector;
	private final PerfumeDataSavingService perfumeDataSavingService;
	private static final Logger logger = LoggerFactory.getLogger(PerfumeDataProcessingPipelineServiceImpl.class);
	
	@Autowired
	public PerfumeDataProcessingPipelineServiceImpl(WebContentFetcher webContentFetcher, DataParserSelector dataParserSelector, PerfumeDataSavingService perfumeDataSavingService) {
		this.webContentFetcher = webContentFetcher;
		this.dataParserSelector = dataParserSelector;
		this.perfumeDataSavingService = perfumeDataSavingService;
		
	}
	
	@Transactional
	@Override
	public void processAndSavePerfumeDataFromUrl(String url){
		
		try {
			// Log the beginning of the method execution
			logger.info("Starting processing of perfume data from URL: {}", url);
			
			//either notino or douglas parser chosen
			logger.info("Selecting data parsing strategy for URL: {}", url);
			DataParsingStrategy strategy = dataParserSelector.selectStrategy(url);
			
			//parse json string into FilteredPerfumeDto
			logger.info("Parsing data string into object for URL: {}", url);
			List<FilteredPerfumeDto> dtos = strategy.parseDataStringIntoObject(url);
			
			//save FilteredPerfumeDto in DataBase
			logger.info("Persisting filtered perfume data for URL: {}", url);
			perfumeDataSavingService.persistFilteredPerfumeData(dtos);
			
			// Log the successful completion of the method
			logger.info("-Successfully processed perfume data from URL: {}", url);
		} catch (Exception e) {
			logger.error("Error processing perfume data from URL: {}", url, e);
			throw e; // Rethrow the exception if needed
		}
	}
	
	public void fetchToFilteredPerfumeDtos(String url){
		//select the strategy from url (notino/douglas fetch&parser)
		DataParsingStrategy strategyServiceUsed = dataParserSelector.selectStrategy(url);
		
		//use the strategy service selected and filled in List of Filtered dtos
		List<FilteredPerfumeDto> filteredPerfumes = strategyServiceUsed.parseDataStringIntoObject(url);
	
		//save filtered perfumes into database
		perfumeDataSavingService.persistFilteredPerfumeData(filteredPerfumes);
	
	}
	public void saveFilteredPerfumesToDataBase(List<FilteredPerfumeDto> filteredData){
		perfumeDataSavingService.persistFilteredPerfumeData(filteredData);
	}
}
