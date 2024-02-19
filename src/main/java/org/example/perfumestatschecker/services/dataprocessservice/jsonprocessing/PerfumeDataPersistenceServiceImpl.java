package org.example.perfumestatschecker.services.dataprocessservice.jsonprocessing;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.*;
import org.example.perfumestatschecker.repositories.OfferRepository;
import org.example.perfumestatschecker.repositories.PerfumeRepository;
import org.example.perfumestatschecker.services.entityservices.brandservice.BrandService;
import org.example.perfumestatschecker.services.entityservices.officeservice.OfferService;
import org.example.perfumestatschecker.services.entityservices.perfumeservice.PerfumeService;
import org.example.perfumestatschecker.services.entityservices.perfumetypeservice.PerfumeTypeService;
import org.example.perfumestatschecker.services.entityservices.perfumevolumeservice.PerfumeVolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfumeDataPersistenceServiceImpl implements PerfumeDataPersistenceService {
	
	private final BrandService brandService;
	
	private final PerfumeTypeService perfumeTypeService;
	
	private PerfumeVolumeService perfumeVolumeService;
	private PerfumeRepository perfumeRepository;
	private OfferRepository offerRepository;
	

	
	private PerfumeService perfumeService;
	private OfferService offerService;
	@Autowired
	public PerfumeDataPersistenceServiceImpl(BrandService brandService, PerfumeTypeService perfumeTypeService,PerfumeVolumeService perfumeVolumeService,PerfumeRepository perfumeRepository,OfferRepository offerRepository, PerfumeService perfumeService, OfferService offerService ) {
		this.brandService = brandService;
		this.perfumeTypeService = perfumeTypeService;
		this.perfumeVolumeService = perfumeVolumeService;
		this.perfumeRepository = perfumeRepository;
		this.offerRepository = offerRepository;
		this.perfumeService = perfumeService;
		this.offerService = offerService;
	}
	
	//Saving the filtered object into the database
	@Transactional
	public void persistFilteredPerfumeData(List<FilteredPerfumeDto> dtos) {
		List<Offer> offersToPersist = new ArrayList<>();
		for(FilteredPerfumeDto dto :dtos){
			//entities to perfume
			Brand brand = brandService.findOrCreate(dto.getBrand());
			PerfumeType perfumeType = perfumeTypeService.findOrCreatePerfumeType(dto.getType());
			PerfumeVolume volume = perfumeVolumeService.findOrCreateVolume(dto.getVolume());
			
			//perfume entity
			Perfume perfume = perfumeService.findOrCreatePerfume(dto.getName(),brand, perfumeType, volume);
			
			//offer entity - perfumeId, price, site, url, timecheck - if perfumeid&&site exist just create timecheck
			Offer offer = offerService.createOrUpdateOffer(dto,perfume);
			offer.setInStock(dto.getStock());
			offersToPersist.add(offer);
		}
		
		//saves all the offers from the loop.
		offerRepository.saveAll(offersToPersist);
		
		
		//
		//offersToPersist.forEach(offer -> timeCheckedService.recordTimeChecked(offer));
		
	}
	private Double parseDouble(String priceStr) {
		try {
			return Double.parseDouble(priceStr);
		} catch (NumberFormatException e) {
			// Log error or handle it according to your error handling strategy
			return null;
		}
	}
	// Similar methods for PerfumeType, PerfumeVolume...
}