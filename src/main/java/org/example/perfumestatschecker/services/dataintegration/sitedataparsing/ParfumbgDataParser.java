package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.services.dataintegration.webdriver.webfetcher.webdriver.WebDriverService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("ParfumBgProcessingStrategy")
public class ParfumbgDataParser implements DataParsingStrategy {
	
	private final WebDriverService driver;
	
	@Autowired
	public ParfumbgDataParser(WebDriverService webDriverService) {
		this.driver = webDriverService;
	}
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String url) {
		driver.initializeWebDriver();
		String htmlString = driver.fetchContent(url, "//*[@id=\"product\"]/div[4]");
		
		Document doc = Jsoup.parse(htmlString);
		
		String perfumeName = doc.select("#product > div.title.page-title").first().text();
		String brandName = doc.select("#product > div.product-price-group > div.product-stats > ul > li.product-manufacturer > a").text();
		List<FilteredPerfumeDto> filteredPerfumeDtos = new ArrayList<>();
		Elements variantElements = doc.select("div.product-variants.description > div");
		
		//System.out.println("Total divs found: " + elements.size());
	/*	for (Element element : elements) {
			System.out.println("Div text: " + element.text());
		}*/
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		for (Element offer : variantElements) {
			FilteredPerfumeDto dto = new FilteredPerfumeDto();
			
			
			String volume = volumeClearance(offer.select("#product > div.product-variants.description > div.col-sm-4.col-md-4.col-lg-3.col-xs-4.variant-active-product > strong").text());
			if(volume.isEmpty()){
				volume = volumeClearance(offer.select("#product > div.product-variants.description > div:nth-child(4) > a > strong").text());
			}
			String price = priceClearance(offer.text());
			String availability = offer.select("body > div:nth-child(4) > div:nth-child(1) > div > div > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > ul > li:nth-child(1) > span").text();
			System.out.println(availability + "EMPTY???");
			availability = availabilityClearance(offer);
			
			//price = volumeClearance(price);
			dto.setName(perfumeName);
			dto.setBrand(brandName);
			dto.setPrice(price);
			dto.setVolume(volume);
			dto.setStock(availability);
			dto.setType("EDP");
			dto.setUrl(url);
			dto.setSite("Parfum.bg");
			System.out.println("price" + price);
			System.out.println("volume" + volume);
			System.out.println("brand" + brandName);
			System.out.println("perfume name" + perfumeName);
			System.out.println("stock" + availability);
			filteredPerfumeDtos.add(dto);
		}
		return filteredPerfumeDtos;
	}
	
	private String volumeClearance(String ml) {
		String numericPart = ml.replaceAll("[^\\d]", "");
		return numericPart;
	}
	
	private String availabilityClearance(Element element) {
		// If the element has the 'variant-out-of-stock-product' class, it's out of stock.
		return element.hasClass("variant-out-of-stock-product") ? "Out of Stock" : "Available";
	}
	private String priceClearance(String price) {
		Pattern pattern = Pattern.compile("(\\d+,\\d+)");
		Matcher matcher = pattern.matcher(price);
		
		if (matcher.find()) {
			// Replace the comma with a dot for standard decimal format
			return matcher.group().replace(',', '.');
		}
		
		return ""; // Return an empty string as default
	}
	
}
