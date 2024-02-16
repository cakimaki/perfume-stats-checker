package org.example.perfumestatschecker.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PerfumePageJsonScrapeImpl {
	
	public void scrapeJsonLdData(){
		// Set path to chromedriver executable
		System.setProperty("chromedriver.exe", "C:/Users/Yordan/Documents/GitHub/perfume-stats-checker/chromedriver.exe");
		
		// Initialize WebDriver
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Run in headless mode (no browser UI)
		WebDriver driver = new ChromeDriver(options);
		
		try {
			// Navigate to the webpage
			driver.get("https://www.notino.bg/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/p-16097522/");
			
			// Extract JSON-LD data
			WebElement scriptElement = driver.findElement(By.xpath("//script[@type='application/ld+json']"));
			String jsonLdContent = scriptElement.getAttribute("innerHTML").trim();
			
			System.out.println(jsonLdContent);
			
			// Parse the JSON-LD content with a JSON parsing library like Jackson or Gson
		} finally {
			// Clean up
			driver.quit();
		}
	}
}
