package org.example.perfumestatschecker.services.dataintegration.sitedataparsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.OfferJson;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.PerfumeJson;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("NotinoProcessingStrategy")
public class NotinoDataParser implements DataParsingStrategy {
	
	@Override
	public List<FilteredPerfumeDto> parseDataStringIntoObject(String jsonResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<FilteredPerfumeDto> filteredPerfumeDtos = new ArrayList<>();
		try {
			// Parse the JSON string into your PerfumeJson class
			PerfumeJson perfumeDetails = objectMapper.readValue(jsonResponse, PerfumeJson.class);

			// Assuming offers is a List and we're interested in the first offer for simplicity
			for (OfferJson offer : perfumeDetails.getOffers()) {
				FilteredPerfumeDto filteredPerfumeDto = new FilteredPerfumeDto();
				filteredPerfumeDto.setBrand(perfumeDetails.getBrand().getName());
				filteredPerfumeDto.setName(extractName(offer.getName()));
				filteredPerfumeDto.setPrice(offer.getPrice());
				filteredPerfumeDto.setSite(extractSiteName(perfumeDetails.getId()));
				filteredPerfumeDto.setUrl(offer.getUrl());
				filteredPerfumeDto.setStock(checkAvailability(offer.getAvailability()));
				filteredPerfumeDto.setDiscount(""); //empty...
				filteredPerfumeDto.setVolume(extractVolume(offer.getName()));
				filteredPerfumeDto.setType(checkPerfumeType(perfumeDetails.getCategory()));
				filteredPerfumeDto.setUrlToImage(offer.getImage());
				filteredPerfumeDtos.add(filteredPerfumeDto);
				
			}
			
			//perfumeService.save(filteredPerfumeDto);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return filteredPerfumeDtos;
	}
	
	//todo
	// this method should be made abstract for all sites.
	private String extractSiteName(String url) {
		try {
			URL parsedUrl = new URL(url);
			String host = parsedUrl.getHost(); // example: www.notino.bg, etc...
			String[] parts = host.split("\\."); // split by '.'
			if (parts.length > 1) {
				return parts[1]; // assuming the site name is the second part
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ""; // return empty if anything else happens
	}
	private String checkPerfumeType(String category){
		if(category.contains("парфюмна вода")){
			return "Eau de Perfume";
		}else if(category.contains("тоалетна вода")){
			return "Eau de Toilette";
		}else if(category.contains("парфюмен екстракт")){
			return "Extract";
		}else{
			return "Perfume";
		}
	}
	
	//logic to see if product available
	private String checkAvailability(String stock){
		if(stock.equals("https://schema.org/InStock")){
			return "Available";
		}else{
			return "Non-available";
		}
	}
	
	// logic to extract the name from the label
	private String extractName(String name) {
		
		// Example: "TOM FORD Eau de Soleil Blanc 100 мл." -> "TOM FORD Eau de Soleil Blanc"
		Pattern pattern = Pattern.compile("^(.*?)\\s*\\d+\\s*мл\\.$"); // Captures everything before the volume
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return matcher.group(1).trim(); // Return the captured name, trimming any leading/trailing spaces
		}
		return "";
	}
	
	// logic to extract numeric part of volume from the name
	private String extractVolume(String name) {
		// Example: "TOM FORD Eau de Soleil Blanc 100 мл." -> "100"
		Pattern pattern = Pattern.compile("(\\d+)\\s*мл"); // Captures one or more digits followed by optional spaces and "мл"
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return matcher.group(1); // Returns only the first capturing group (the digits)
		}
		return "";
	}
}