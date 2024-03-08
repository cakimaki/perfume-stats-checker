package org.example.perfumestatschecker.services.dataintegration;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParserSelector;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;

import org.example.perfumestatschecker.services.dataintegration.webdriver.workingFetcherRn.WebContentFetcher;
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
		
		//either notino or douglas parser chosen
		DataParsingStrategy strategy = dataParserSelector.selectStrategy(url);
		
		//parse json string into FilteredPerfumeDto
		List<FilteredPerfumeDto> dtos = strategy.parseDataStringIntoObject(url);
		
		//save FilteredPerfumeDto in DataBase
		perfumeDataSavingService.persistFilteredPerfumeData(dtos);
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
