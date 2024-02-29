/*
package org.example.perfumestatschecker.services.dataintegration.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WebDriverManager {
	private final WebDriver driver;

	public WebDriverManager(@Value("${webdriver.chrome.driver}") String chromeDriverPath){
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--headless");
		options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-blink-features=AutomationControlled");
		
		this.driver = new ChromeDriver(options);
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public void closeDriver(){
		if(driver != null){
			driver.quit();
		}
	}
	
}
*/
