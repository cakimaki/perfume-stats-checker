package org.example.perfumestatschecker.services.dataprocessservice.perfumeProcessingStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.OfferJson;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.PerfumeJson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("NotinoProcessingStrategy")
public class NotinoProcessingStrategy implements PerfumeProcessingStrategy {
	
	@Override
	public List<FilteredPerfumeDto> processAndSavePerfumeData(String jsonResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		List<FilteredPerfumeDto> filteredPerfumeDtos = new ArrayList<>();
		try {
			// Parse the JSON string into your PerfumeJson class
			PerfumeJson perfumeDetails = objectMapper.readValue(jsonResponse, PerfumeJson.class);
			
			System.out.print("--------------");
			System.out.printf(jsonResponse);
			System.out.println("---------------");
			
			
			// Assuming offers is a List and we're interested in the first offer for simplicity
			for (OfferJson offer : perfumeDetails.getOffers()) {
				FilteredPerfumeDto filteredPerfumeDto = new FilteredPerfumeDto();
				filteredPerfumeDto.setBrand(perfumeDetails.getBrand().getName());
				filteredPerfumeDto.setName(extractName(offer.getName()));
				filteredPerfumeDto.setPrice(offer.getPrice());
				filteredPerfumeDto.setSite(perfumeDetails.id);
				filteredPerfumeDto.setUrl(offer.getUrl());
				filteredPerfumeDto.setStock(checkAvailability(offer.getAvailability()));
				filteredPerfumeDto.setDiscount(""); //empty...
				filteredPerfumeDto.setVolume(extractVolume(offer.getName()));
				filteredPerfumeDto.setType(checkPerfumeType(perfumeDetails.getCategory()));
				filteredPerfumeDtos.add(filteredPerfumeDto);
			}
			
			//perfumeService.save(filteredPerfumeDto);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return filteredPerfumeDtos;
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
	private boolean checkAvailability(String stock){
		if(stock.equals("https://schema.org/InStock")){
			return true;
		}else{
			return false;
		}
	}
	
	// logic to extract the name from the label
	private String extractName(String name) {
		
		// Example: "TOM FORD Eau de Soleil Blanc 100 мл." -> "TOM FORD Eau de Soleil Blanc"
		Pattern pattern = Pattern.compile("^(.*?)\\s*\\d+\\s*мл\\.$"); // Capture everything before the volume
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return matcher.group(1).trim(); // Return the captured name, trimming any leading/trailing spaces
		}
		return ""; // Return empty string if name not found
	}
	
	// logic to extract numeric part of volume from the name
	private String extractVolume(String name) {
		// Example: "TOM FORD Eau de Soleil Blanc 100 мл." -> "100"
		Pattern pattern = Pattern.compile("(\\d+)\\s*мл"); // Captures one or more digits followed by optional spaces and "мл"
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return matcher.group(1); // Return only the first capturing group (the digits)
		}
		return ""; // Return empty string if volume not found
	}
}