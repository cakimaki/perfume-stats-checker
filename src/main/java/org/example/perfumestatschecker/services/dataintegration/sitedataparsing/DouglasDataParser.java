package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.apache.logging.log4j.LogManager;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.PerfumeUpdateServiceImpl;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;
import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("DouglasProcessingStrategy")
public class DouglasDataParser implements DataParsingStrategy {

	
	private final WebDriverService driver;
/*
todo---------------------------------
todo ---- NOT YET IMPLEMENTED ------
todo---------------------------------
*/
	private static final Logger logger = LoggerFactory.getLogger(DouglasDataParser.class);
	
	public DouglasDataParser(WebDriverService driver) {
		this.driver = driver;
	}
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String url){
		String htmlContent = driver.fetchContent(url);
		
		//todo finish returning List of FilteredDtos
		List<FilteredPerfumeDto> dto = new ArrayList<>();
		
		
	}

}

