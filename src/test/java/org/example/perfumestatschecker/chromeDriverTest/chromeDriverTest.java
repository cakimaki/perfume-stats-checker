package org.example.perfumestatschecker.chromeDriverTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.junit.jupiter.api.Test;

public class chromeDriverTest {
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		
		System.setProperty("chromedriver.exe", "C:/Users/Yordan/Documents/GitHub/perfume-stats-checker/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.com/");
		
		Thread.sleep(5000);  // Let the user actually see something!
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		searchBox.sendKeys("ChromeDriver");
		
		searchBox.submit();
		
		Thread.sleep(5000);  // Let the user actually see something!
		
		driver.quit();
		
	}
	
}
