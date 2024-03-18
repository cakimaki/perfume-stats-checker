package org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class WebDriverServiceImpl implements WebDriverService {
	@Value("${webdriver.chrome.driver}")
	private String chromeDriverPath;
	private WebDriver driver;
	
	@Override
	public WebDriver initializeWebDriver() {
		// Set the path to your WebDriver executable
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
		//options.addArguments("set_window_position(-2000,0)");
		if (this.driver != null) {
			this.driver.quit(); // Quit the previous driver instance if it exists
		}
		
		this.driver = new ChromeDriver(options);
		return driver;
	}
	@Override
	public WebElement findElement(By by) {
		if (this.driver == null) {
			initializeWebDriver(); // Make sure WebDriver is initialized
		}
		return driver.findElement(by); // Use WebDriver's findElement
	}
	@Override
	public List<WebElement> findElements(By by){
		return driver.findElements(by);
	}
	@Override
	public void get(String site){
		driver.get(site);
	}
	
	//overloaded method
	@Override
	public String fetchContent(String url) {
		return fetchContent(url, "", ""); // Pass empty strings if no waiting or specific script execution is needed
	}
	@Override
	public String fetchContent(String url,String waitCond) {
		return fetchContent(url, waitCond, ""); // Pass empty strings if no waiting or specific script execution is needed
	}
	@Override
	public String fetchContent(String url, String waitConditionXPath, String scriptForExtraction) {
		if (driver == null) {
			driver = initializeWebDriver();
		}
		try {
			
			driver.get(url);
			// Wait for the specific condition if provided
			if (!waitConditionXPath.isEmpty()) {
				new WebDriverWait(driver, Duration.ofSeconds(15))
						.until(ExpectedConditions.presenceOfElementLocated(By.xpath(waitConditionXPath)));
			}
			// Execute the script for extraction if provided, else return page source or specific element content
			if (!scriptForExtraction.isEmpty()) {
				return (String) ((JavascriptExecutor) driver).executeScript(scriptForExtraction);
			} else {
				// Fallback to return page source or specific HTML extraction logic can be implemented here
				return driver.getPageSource();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; // Handle the exception appropriately
		}
	}
	@Override
	public WebDriverWait optionsWait(int duration){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		return wait;
	}
	
	@Override
	public WebElement waitForElement(By by, int timeoutInSeconds) {
		if (this.driver == null) {
			initializeWebDriver();
		}
		try{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			
			return wait.until(ExpectedConditions.presenceOfElementLocated(by));
		}catch(Exception e){
			throw new RuntimeException("it hasnt found the path??");
		}
	}
	
	@Override
	public void closeWebDriver(){
		if(driver != null){
			driver.quit();
			this.driver = null;
		}
	}
}
