/*
package org.example.perfumestatschecker.services.dataintegration.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FetcherService {
	private final WebDriverManager webDriverManager;
	private final FetchStrategy fetchStrategy;
	
	@Autowired
	public FetcherService(WebDriverManager webDriverManager, FetchStrategy fetchStrategy) {
		this.webDriverManager = webDriverManager;
		this.fetchStrategy = fetchStrategy;
	}
	
	public String fetchJsonFromUrl(String url) {
		return fetchStrategy.fetch(webDriverManager.getDriver(), url);
	}
}
*/
