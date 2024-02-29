package org.example.perfumestatschecker.services.dataintegration.webdriver.workingFetcherRn;

import org.example.perfumestatschecker.services.dataintegration.webdriver.workingFetcherRn.WebContentFetcher;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class WebContentFetcherImpl implements WebContentFetcher {
	
	@Value("${webdriver.chrome.driver}")
	private String chromeDriverPath;
	
	@Override
	public String fetchJsonFromUrl(String url) {
		// Set the path to your WebDriver executable
		if(url == null || url.isEmpty()){
			throw new IllegalArgumentException("Url is empty web driver crash.");
		}
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
		
		WebDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // wait for a maximum of 10 seconds
		
		try {
			driver.get(url);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//script[@type='application/ld+json']")));
			
			// Using JavaScript to extract the JSON directly might be more reliable
			String scriptContent = (String) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
					"for (const script of document.querySelectorAll('script[type=\"application/ld+json\"]')) {" +
							"  if (script.textContent.includes('@type\":\"Product\"')) {" +
							"    return script.textContent;" +
							"  }" +
							"}" +
							"return '';"); // Return an empty string if not found
			
			return scriptContent; // Return the extracted JSON string
			
		} catch (Exception e) {
			e.printStackTrace();
			return null; // Return null in case of an error
		} finally {
			driver.quit(); // Ensure the driver is closed
		}
	}
}