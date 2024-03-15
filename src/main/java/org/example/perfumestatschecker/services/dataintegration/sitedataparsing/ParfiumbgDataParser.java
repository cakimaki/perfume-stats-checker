package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;

@Component("ParfiumbgDataParser")
public class ParfiumbgDataParser implements DataParsingStrategy {
	
	private final WebDriverService driver;
	
	@Autowired
	public ParfiumbgDataParser(WebDriverService webDriverService){
		this.driver = webDriverService;
	}
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String url) {
		return null;
	}
	

	
}
