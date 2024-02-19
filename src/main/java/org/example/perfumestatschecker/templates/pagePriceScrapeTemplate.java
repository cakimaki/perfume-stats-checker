package org.example.perfumestatschecker.templates;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class pagePriceScrapeTemplate{
	public static void main(String[] args) {
		// Set the path to your WebDriver executable
		System.setProperty("chromedriver.exe", "C:/Users/Yordan/Documents/GitHub/perfume-stats-checker/chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for a maximum of 10 seconds
		
		try {
			driver.get("https://www.notino.bg/tom-ford/eau-de-soleil-blanc-toaletna-voda-uniseks/");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//script[@type='application/ld+json']")));
			
			// Using JavaScript to extract the JSON directly might be more reliable
			String scriptContent = (String) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
					"for (const script of document.querySelectorAll('script[type=\"application/ld+json\"]')) {" +
							"  if (script.textContent.includes('@type\":\"Product\"')) {" +
							"    return script.textContent;" +
							"  }" +
							"}" +
							"return '';"); // Return an empty string if not found
			
			if (!scriptContent.isEmpty()) {
				System.out.println("Extracted JSON-LD: " + scriptContent);
				
				// Parse the JSON content
				ObjectMapper objectMapper = new ObjectMapper();
				Map<String, Object> jsonMap = objectMapper.readValue(scriptContent, new TypeReference<Map<String,Object>>(){});
				
				System.out.println("Parsed JSON: " + jsonMap.toString());
				// Now you can access any part of the parsed JSON
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}

