package org.example.perfumestatschecker.services.dataprocessservice.perfumeProcessingStrategy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.OfferJson;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.PerfumeJson;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("NotinoProcessingStrategy")
public class NotinoProcessingStrategy implements PerfumeProcessingStrategy {
	
	@Override
	public FilteredPerfumeDto processAndSavePerfumeData(String jsonResponse) {
		ObjectMapper objectMapper = new ObjectMapper();
		FilteredPerfumeDto filteredPerfumeDto = new FilteredPerfumeDto();
		try {
			// Parse the JSON string into your PerfumeJson class
			PerfumeJson perfumeDetails = objectMapper.readValue(jsonResponse, PerfumeJson.class);
			System.out.printf("--------------");
			System.out.printf(jsonResponse);
			System.out.printf("---------------");
			// Now, create and fill the FilteredPerfumeDto instance
			
			
			// Assume that perfumeDetails contains the fields directly or indirectly to populate FilteredPerfumeDto
			// Here's an example of how you might extract the necessary information:
			filteredPerfumeDto.setBrand(perfumeDetails.getBrand().getName());
			
			
			// Assuming offers is a List and we're interested in the first offer for simplicity
			for(OfferJson offerIterating : perfumeDetails.getOffers()){
				filteredPerfumeDto.setName(offerIterating.getName());
				filteredPerfumeDto.setPrice(offerIterating.getPrice());
				filteredPerfumeDto.setUrl(offerIterating.getUrl());
				filteredPerfumeDto.setStock(offerIterating.getAvailability());
				filteredPerfumeDto.setDiscount("Determine how to calculate"); // You need to determine how to get discount
				filteredPerfumeDto.setVolume(extractVolume(offerIterating.getName()));
				// You may need additional logic to extract and set the type, discount, and stock correctly.
			}
			
			//perfumeService.save(filteredPerfumeDto);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return filteredPerfumeDto;
	}
	
	private String extractVolume(String name) {
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(name);
		if (matcher.find()) {
			return matcher.group();
		}
		return ""; // Return empty string or some default value if volume not found
	}
}