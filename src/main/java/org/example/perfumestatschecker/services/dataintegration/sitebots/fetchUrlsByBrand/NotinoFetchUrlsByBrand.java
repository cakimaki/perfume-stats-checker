package org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand;

import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("NotinoFetchUrlsByBrand")
public class NotinoFetchUrlsByBrand implements FetchUrlsStrategy{
	@Autowired
	private WebDriverService driverService;
	
	@Override
	public List<String> fetchPerfumeUrlsByBrand(String brand) throws InterruptedException {
		driverService.initializeWebDriver();
		List<String> perfumeUrls = new ArrayList<>();
		driverService.get("https://www.notino.bg/" + brand.replace(' ', '-') + "/");
		
		//checks
		System.out.println("https://www.notino.bg/" + brand.replace(' ','-') + "/");
		System.out.println("notino method chosen");
		
		
		List<WebElement> perfumeElements = driverService.findElements(By.cssSelector("#productListWrapper > div.styled__PageGridWrapper-sc-1yds6ou-0.dYBjPx > div > a"));
		
		int cnt = 0;
		for (WebElement perfume : perfumeElements) {
			perfumeUrls.add(perfume.getAttribute("href"));
			cnt++;
		}
		
		return perfumeUrls;
	}
	
}
