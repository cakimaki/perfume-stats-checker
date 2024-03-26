package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

@Component("ParfiumBgProcessingStrategy")
public class ParfiumbgDataParser implements DataParsingStrategy {
	private final WebDriverService driver;
	
	@Autowired
	public ParfiumbgDataParser(WebDriverService driver){
		this.driver=driver;
	}
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String url) {
		driver.initializeWebDriver();
		String htmlData = driver.fetchContent(url, "/html/body/main");
		Document doc = Jsoup.parse(htmlData);
		
		String perfumeName = doc.select("body > main > div.container > div > div.product-title.categoryid > div > div.title-box-main > h1").text();
		String brandName = doc.select("body > div.product-history-lent.light-background > div > ul > li:nth-child(4) > span > a > span").text();
		
		List<FilteredPerfumeDto> filteredPerfumeDtos = new ArrayList<>();
		Elements offersInsideSite = doc.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2)");
		for(Element offer : offersInsideSite){
			FilteredPerfumeDto dto = new FilteredPerfumeDto();
			
			String volume = offer.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.left-opt > span.ml").text();
			String price = doc.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.right-opt.flex-promo > meta:nth-child(5)").attr("content");
			String priceWoDiscount = offer.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.right-opt.flex-promo > div > span").text();
			String availability = offer.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.right-opt.flex-promo > meta:nth-child(3)").text();
			
			if(price.isEmpty()){
				price = doc.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.right-opt.flex-promo > meta:nth-child(4)").attr("content");
			}
			if(availability.isEmpty()){
				availability = offer.select("body > main > div.container > div > div.product-right-side > div > form > div.mobile-price-listing > div > label:nth-child(2) > div.right-opt.flex-promo > meta:nth-child(2)").attr("content");
			}
			//todo
			//  change this
			String type = "EDP";
			
			volume = volumeClearance(volume);
			priceWoDiscount = priceClearance(priceWoDiscount);
			dto.setBrand(brandName);
			dto.setName(perfumeName);
			dto.setVolume(volume);
			dto.setStock(availability);
			dto.setType(type);
			dto.setPrice(price);
			dto.setDiscountedPrice(priceWoDiscount);
			System.out.println(dto);
			filteredPerfumeDtos.add(dto);
		}
		return filteredPerfumeDtos;
	}
	private String priceClearance(String priceFromSite){
		String cleanedPrice = priceFromSite.replaceAll("[^\\d.,]", "");
		// Remove trailing dot if it's not part of the decimal numbers
		if (cleanedPrice.matches(".*\\.\\D*")) { // Checks if there's a dot followed by non-digit characters at the end
			cleanedPrice = cleanedPrice.replaceAll("\\.\\D*$", ""); // Removes the dot and any trailing non-digit characters
		}
		
		return cleanedPrice.replace(",",".");
	}
	private String volumeClearance(String ml) {
		String numericPart = ml.replaceAll("[^\\d]", "");
		return numericPart;
	}
	
	private String stockClearance(String stock){
		if(stock.contains("OutOfStock")){
			return "Non-available";
		}
		if(stock.contains("InStock")){
			return "Available";
		}
		return "";
	}
}
