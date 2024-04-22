package org.example.perfumestatschecker.services.dataintegration.sitebots.fetchUrlsByBrand;

import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component("ParfumBgFetchUrlsByBrand")
public class ParfumBgFetchUrlsByBrand implements FetchUrlsStrategy{
	@Autowired
	private WebDriverService driverService;
	
	@Override
	public List<String> fetchPerfumeUrlsByBrand(String brand) throws InterruptedException {
		driverService.initializeWebDriver();
		List<String> perfumeUrls = new ArrayList<>();
		driverService.get("https://parfum.bg/" + brand.replace(' ','-') + "/");
		//https://parfum.bg/tom-ford/
		int index = 2;
		int n = Integer.parseInt(driverService.findElement(By.cssSelector("#content > div.main-products-wrapper > div.row.pagination-results > div.col-sm-6.text-left > ul > li:nth-child(4) > a")).getText());
		System.out.println("NUM" + n);
		
		for (int i = 2; i <= n; i++) {
			TimeUnit.SECONDS.sleep(3);
			
			List<WebElement> perfumeElements = driverService.findElements(By.cssSelector("#content > div.main-products-wrapper > div.main-products.product-grid > div > div > div.caption > div.name > a"));
			
			for (WebElement element : perfumeElements) {
				perfumeUrls.add(element.getAttribute("href"));
			}
			System.out.println(perfumeUrls.size() +"-------------" + perfumeUrls);
			driverService.get("https://parfum.bg/" + brand.replace(' ','-') + "/?page=" + String.valueOf(i));
		}
		//https://parfum.bg/tom-ford/?page=2

		return perfumeUrls;
	}
}
