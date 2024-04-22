package org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand;

import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component("DouglasFetchUrlsByBrand")
public class DouglasFetchUrlsByBrand implements FetchUrlsStrategy{
	@Autowired
	private WebDriverService driver;
	
	@Override
	public List<String> fetchPerfumeUrlsByBrand(String brand) throws InterruptedException {
		driver.initializeWebDriver();
		List<String> perfumeUrls = new ArrayList<>();
		driver.get("https://douglas.bg/");
		System.out.println("douglas method chosen");
		WebElement searchBox = driver.waitForElement(By.cssSelector("#html-body > div.page-wrapper > header > div.header.content > section > div > section.amsearch-input-wrapper.-dynamic-width > input"), 15);
		searchBox.sendKeys(brand);
		
		WebElement cookiesAcceptButton = driver.waitForElement(By.cssSelector("#btn-cookie-allow"), 30);
		cookiesAcceptButton.click();
		
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		// Assuming you need to wait for the search button to be clickable
		WebElement searchButton = driver.waitForElement(By.cssSelector("#html-body > div.page-wrapper > header > div.header.content > section > div > section.amsearch-input-wrapper.-dynamic-width.-match.-typed > button.amsearch-button.-loupe.-clear.-icon"), 30);
		searchButton.click();
		
		
		// Wait for the page to load and select '72' from the combo box
		WebElement comboBox = driver.waitForElement(By.cssSelector("#limiter"), 15);
		new Select(comboBox).selectByVisibleText("72");
		
		List<WebElement> perfumesElements = driver.findElements(By.cssSelector("#amasty-shopby-product-list > div.products.wrapper.grid.products-grid > ol > li > div > a"));
		for (WebElement perfume : perfumesElements) {
			perfumeUrls.add(perfume.getAttribute("href"));
		}
		return perfumeUrls;
	}

}
