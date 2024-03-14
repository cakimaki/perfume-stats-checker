package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.apache.logging.log4j.LogManager;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.PerfumeUpdateServiceImpl;
import org.example.perfumestatschecker.services.dataintegration.sitedataparsing.DataParsingStrategy;
import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.jsoup.nodes.Element;

@Component("DouglasProcessingStrategy")
public class DouglasDataParser implements DataParsingStrategy {
	
	
	private final WebDriverService driver;
	/*
	todo---------------------------------
	todo ---- NOT YET IMPLEMENTED ------
	todo---------------------------------
	*/
	private static final Logger logger = LoggerFactory.getLogger(DouglasDataParser.class);
	
	public DouglasDataParser(WebDriverService driver) {
		this.driver = driver;
	}
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String url) {
		driver.initializeWebDriver();
		//fetch the page html
		String htmlContent = driver.fetchContent(url, "//script[@type='application/ld+json']");
		
		//todo finish returning List of FilteredDtos
		List<FilteredPerfumeDto> filteredPerfumeDtos = new ArrayList<>();
		
		Document doc = Jsoup.parse(htmlContent);
		
		// extract name and brand
		String productName = doc.select("h1.page-title[itemprop='name']").text();
		String brandName = doc.select("meta[itemprop=name]").first().attr("content");
		
		// Iterate over each product option if available
		Elements offerElements = doc.select(".swatch-option.text");
		if (offerElements.isEmpty()) {//if there arent options and its only 1
			FilteredPerfumeDto dto = new FilteredPerfumeDto();
			String volume = volumeClearance(doc.select("#weight-container").first().text()); // first because it returns Elements and text because it needs to be parsed to string
			
			//price
			String price = "";
			Elements priceElements = doc.select("[id^=product-price-]");
			
			for (Element priceElement : priceElements) {
				price = priceElement.attr("data-price-amount");
				if (!price.isEmpty()) {
					break; // Break the loop once a non-empty price is found
				}
			}
			
			String discountedPrice = doc.select("#old-price-194717").attr("data-price-amount");
			String availability = availabilityClearance(doc.select("div.stock.stock-availability.available span").first().text());
			String type = doc.select("#product-attribute-specs-table > span.value.tipove").text();
			
			System.out.println(type);
			type = typeClearance(type);
			System.out.println(volume);
			System.out.println(price);
			System.out.println(discountedPrice);
			System.out.println(availability);
			System.out.println(productName);
			System.out.println(brandName);
			System.out.println(type);
			
			dto.setName(productName);
			dto.setBrand(brandName);
			dto.setSite("Douglas"); // Assuming "Douglas" is the static site name
			dto.setUrl(url); // The URL passed to this method
			dto.setVolume(volume);
			dto.setPrice(price); // Implement this method to parse and return the price
			dto.setDiscountedPrice(discountedPrice);
			dto.setStock(availability);
			
			//dto.setDiscount(calculateDiscount(specialPrice, oldPrice)); // Implement this method based on your discount logic
			// Set other DTO fields as necessary
			
			filteredPerfumeDtos.add(dto);
		} else {
			
			for (Element offerElement : offerElements) {
				FilteredPerfumeDto dto = new FilteredPerfumeDto();
				dto.setName(productName);
				dto.setBrand(brandName);
				dto.setSite("Douglas"); // Assuming "Douglas" is the static site name
				dto.setUrl(url); // The URL passed to this method
				
				// Example: Extract the volume and prices
				String volume = volumeClearance(offerElement.attr("aria-label"));
				String price = priceClearance(offerElement.select(".additional-option-special-price").text());
				if(price.isEmpty()){
					price = priceClearance(offerElement.select(".additional-option-pdc-price").text());//its not always the upper case
				}
				if(price.isEmpty()){
					price = priceClearance(offerElement.select(".additional-option-final-price").text());//if price is still 0..
				}
			
				String discountedPrice = priceClearance(offerElement.select(".additional-option-old-price").text());
				String availability = availabilityClearance(doc.select("div.stock.stock-availability.available span").first().text());
				String type = typeClearance(doc.select("#product-attribute-specs-table > span.value.tipove").text());
				//
				dto.setName(productName);
				dto.setBrand(brandName);
				dto.setSite("Douglas"); // Assuming "Douglas" is the static site name
				dto.setUrl(url); // The URL passed to this method
				dto.setVolume(volume);
				dto.setPrice(price); // Implement this method to parse and return the price
				dto.setDiscountedPrice(discountedPrice);
				dto.setStock(availability);//todo update this cause its not working properly for every option, only the clicked one
				dto.setType(type);
				//dto.setPrice(extractPrice(specialPrice)); // Implement this method to parse and return the price
				//dto.setDiscount(calculateDiscount(specialPrice, oldPrice)); // Implement this method based on your discount logic
				// Set other DTO fields as necessary
				
				filteredPerfumeDtos.add(dto);
			}
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
	
	private String typeClearance(String typeFromSite){
		if(typeFromSite.equals("Парфюмна вода (EDP)")){
			return "EDP";
		}else{
			return " kakvo??? ";
		}
	}
	private String availabilityClearance(String availFromSite){
		if(availFromSite.equals("Наличен")){
			return "Available";
		}else{
			return "Non-available";
		}
	}
	private String volumeClearance(String ml) {
		String numericPart = ml.replaceAll("[^\\d]", "");
		return numericPart;
	}
	
}

