package org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface WebDriverService {
	
	WebDriver initializeWebDriver();
	
	String fetchContent(String url);
	
	String fetchContent(String url, String waitConditionXPath, String scriptForExtraction);
	
	WebDriverWait optionsWait();
	
	void closeWebDriver();
}
