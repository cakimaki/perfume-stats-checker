package org.example.perfumestatschecker.services.dataintegration.sitebots;

import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class FetchPerfumesByBrand {
	@Autowired
	private WebDriverService driver;
	
	public List<String> fetchUrlsByBrand(String site, String brand) {
		driver.initializeWebDriver();
		driver.get(site);
		
		WebElement searchBox = driver.waitForElement(By.cssSelector("#html-body > div.page-wrapper > header > div.header.content > section > div > section.amsearch-input-wrapper.-dynamic-width > input"), 15);
		searchBox.sendKeys(brand);
		
		WebElement cookiesAcceptButton = driver.waitForElement(By.cssSelector("#btn-cookie-allow"), 30);
		cookiesAcceptButton.click();
		
		// Assuming you need to wait for the search button to be clickable
		WebElement searchButton = driver.waitForElement(By.cssSelector("#html-body > div.page-wrapper > header > div.header.content > section > div > section.amsearch-input-wrapper.-dynamic-width.-match.-typed > button.amsearch-button.-loupe.-clear.-icon"), 30);
		searchButton.click();
		
		
		// Wait for the page to load and select '72' from the combo box
		WebElement comboBox = driver.waitForElement(By.cssSelector("#limiter"), 15);
		new Select(comboBox).selectByVisibleText("72");
		
		List<WebElement> perfumesElements = driver.findElements(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li > div > a"));
		List<String> perfumeUrls = new ArrayList<>();
		for (WebElement perfume : perfumesElements) {
			perfumeUrls.add((perfume.getAttribute("href"))); // Or any other attribute you're interested in
		}
		return perfumeUrls;
	}
	
}
