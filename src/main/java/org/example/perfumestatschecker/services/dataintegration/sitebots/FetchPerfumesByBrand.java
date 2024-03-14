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
import java.util.concurrent.TimeUnit;

@Service
public class FetchPerfumesByBrand {
	@Autowired
	private WebDriverService driver;
	
	
	public List<String> fetchUrlsByBrand(String site, String brand) {
		driver.initializeWebDriver();
		List<String> perfumeUrls = new ArrayList<>();
		if (site.contains("douglas")) {
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
		}else{
			driver.get("https://www.notino.bg/"+brandInUrlClearance(brand) + "/");
			
			//checks
			System.out.println("https://www.notino.bg/"+brandInUrlClearance(brand) + "/");
			System.out.println("notino method chosen");
			
			
			
			List<WebElement> perfumeElements = driver.findElements(By.cssSelector("#productListWrapper > div.styled__PageGridWrapper-sc-1yds6ou-0.dYBjPx > div > a"));
			
			int cnt= 0;
			for(WebElement perfume : perfumeElements){
				perfumeUrls.add(perfume.getAttribute("href"));
				cnt++;
			}
			
			System.out.println(cnt);
			System.out.println("button shouldve been clicked...");
			
		}
		return perfumeUrls;
	}
	public String brandInUrlClearance(String brand){
		return brand.replace(' ','-');
	}
}
