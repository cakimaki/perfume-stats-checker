/*
package org.example.perfumestatschecker.services.dataintegration.webdriver;

import org.springframework.stereotype.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

@Component
public class JsonNotinoFetchStrategy implements FetchStrategy {
	@Override
	public String fetch(WebDriver driver, String url) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {
			driver.get(url);
			// Wait for the page to load.
			Thread.sleep(5000); // Ideally, replace with more precise wait conditions.
			
			// Check for Cloudflare's challenge.
			if (isCloudflareChallengePresent(driver)) {
				handleCloudflareChallenge(driver, wait);
			}
			
			// Wait for the specific JSON data script tag to be present.
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//script[@type='application/ld+json']")));
			// Extract and return the JSON data.
			return (String) ((JavascriptExecutor) driver).executeScript(
					"return Array.from(document.querySelectorAll('script[type=\"application/ld+json\"]'))" +
							".find(script => script.textContent.includes('@type\":\"Product\"')).textContent || '';");
		} catch (Exception e) {
			System.err.println("An error occurred: " + e.getMessage());
			return null;
		}
	}
	
	private boolean isCloudflareChallengePresent(WebDriver driver) {
		// This can be refined based on the specific indicators of Cloudflare's challenge on the page.
		return !driver.findElements(By.cssSelector("iframe[title*='challenge']")).isEmpty();
	}
	
	private void handleCloudflareChallenge(WebDriver driver, WebDriverWait wait) throws Exception {
		// Switch to the iframe containing Cloudflare's challenge.
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title*='challenge']")));
		// Attempt to click the verification checkbox or button. This selector might need adjustments.
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.mark"))).click();
		// Switch back to the main content.
		driver.switchTo().defaultContent();
		// Additional logic to wait for the challenge to be resolved before proceeding.
	}
}*/
