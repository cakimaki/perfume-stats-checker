package org.example.perfumestatschecker.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.perfumestatschecker.dtos.JsonExtractNotino.PerfumeJson;
import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Offer;
import org.example.perfumestatschecker.models.PerfumeType;
import org.example.perfumestatschecker.models.PerfumeVolume;
import org.example.perfumestatschecker.services.brandservice.BrandService;
import org.example.perfumestatschecker.repositories.OfferRepository;
import org.example.perfumestatschecker.repositories.PerfumeRepository;
import org.example.perfumestatschecker.services.perfumetypeservice.PerfumeTypeService;
import org.example.perfumestatschecker.services.perfumevolumeservice.PerfumeVolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfumeDataServiceImpl implements PerfumeDataService {
	
	private final PerfumeRepository perfumeRepository;
	private final OfferRepository offerRepository;
	
	private final BrandService brandService;
	private final PerfumeVolumeService perfumeVolumeService;
	private final PerfumeTypeService perfumeTypeService;
	
	@Autowired
	public PerfumeDataServiceImpl(PerfumeRepository perfumeRepository, OfferRepository offerRepository,
	                              BrandService brandService, PerfumeVolumeService perfumeVolumeService,
	                              PerfumeTypeService perfumeTypeService) {
		this.perfumeRepository = perfumeRepository;
		this.offerRepository = offerRepository;
		this.brandService = brandService;
		this.perfumeVolumeService = perfumeVolumeService;
		this.perfumeTypeService = perfumeTypeService;
		
	}
	
	
	@Override
	public void savePerfumeData(String jsonString) throws Exception {
		//import object mapper
		ObjectMapper objectMapper = new ObjectMapper();
		//parse json string to object
		PerfumeJson perfumeJson = objectMapper.readValue(jsonString, PerfumeJson.class);
		
		// Create a new perfume entity and save it
		Brand brand = brandService.findOrCreate(perfumeJson.brand.name);
		PerfumeVolume volume = volumeService.determineVolume(perfumeJson); // Implement logic based on JSON
		PerfumeType type = typeService.determineType(perfumeJson); // Implement logic based on JSON

		
		// Just save one image URL, assuming you want the first one
		if (!perfumeJson.image.isEmpty()) {
			perfume.setImageUrl(perfumeJson.image.get(0));
		}
		
		for (Offer offer : perfumeJson.offers) {
			// Here you can save each offer's details as needed
			// For example, to create and save offer entities related to this perfume
			perfume.addOffer(offer.name, offer.getVolumeInMl(), offer.availability.equals("https://schema.org/InStock"), offer.price);
		}
		
		perfumeRepository.save(perfume);
	}
}

