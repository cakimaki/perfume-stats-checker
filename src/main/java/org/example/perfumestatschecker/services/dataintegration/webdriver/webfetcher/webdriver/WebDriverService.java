package org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public interface WebDriverService {
	
	WebDriver initializeWebDriver();
	
	List<WebElement> findElements(By by);
	
	String fetchContent(String url);
	
	String fetchContent(String url, String waitCond);
	
	String fetchContent(String url, String waitConditionXPath, String scriptForExtraction);
	
	WebDriverWait optionsWait();
	
	WebElement waitForElement(By by, int timeoutInSeconds);
	
	void closeWebDriver();
	
	WebElement findElement(By by);
	
	void get(String site);
}
