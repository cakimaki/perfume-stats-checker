package org.example.perfumestatschecker.services.dataintegration.storingdata;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.*;
import org.example.perfumestatschecker.models.perfume.*;
import org.example.perfumestatschecker.repositories.offer.OfferRepository;
import org.example.perfumestatschecker.services.entityservices.offerservice.site.SiteService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.brandservice.BrandService;
import org.example.perfumestatschecker.services.entityservices.offerservice.offerstatusservice.OfferStatusService;
import org.example.perfumestatschecker.services.entityservices.offerservice.offerservice.OfferService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumenameservice.PerfumeService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice.PerfumeVariantService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumetypeservice.PerfumeTypeService;
import org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumevolumeservice.PerfumeVolumeService;
import org.example.perfumestatschecker.services.entityservices.offerservice.priceservice.PriceService;
import org.example.perfumestatschecker.services.entityservices.offerservice.stockstatusservice.StockStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfumeDataSavingServiceImpl implements PerfumeDataSavingService {
	
	private final BrandService brandService;
	
	private final PerfumeTypeService perfumeTypeService;
	
	private final PerfumeVolumeService perfumeVolumeService;
	private final PerfumeService perfumeService;
	private final OfferRepository offerRepository;
	
	private final PerfumeVariantService perfumeVariantService;
	private final SiteService siteService;
	private final OfferService offerService;
	private final OfferStatusService offerStatusService;
	
	private final PriceService priceService;
	
	private final StockStatusService stockStatusService;
	private final ConversionService conversionService;
	
	
	
	@Autowired
	public PerfumeDataSavingServiceImpl(BrandService brandService, PerfumeTypeService perfumeTypeService,
	                                    PerfumeVolumeService perfumeVolumeService, OfferRepository offerRepository,
	                                    PerfumeVariantService perfumeVariantService, OfferService offerService, OfferStatusService offerStatusService,
	                                    PriceService priceService, ConversionService conversionService, StockStatusService stockStatusService,
	                                    PerfumeService perfumeService, SiteService siteService) {
		this.brandService = brandService;
		this.perfumeTypeService = perfumeTypeService;
		this.perfumeVolumeService = perfumeVolumeService;
		this.offerRepository = offerRepository;
		this.perfumeVariantService = perfumeVariantService;
		this.offerService = offerService;
		this.offerStatusService = offerStatusService;
		this.priceService = priceService;
		this.conversionService= conversionService;
		this.stockStatusService = stockStatusService;
		this.perfumeService = perfumeService;
		this.siteService = siteService;
	}
	
	//Saving the filtered object into the database
	@Transactional
	public void persistFilteredPerfumeData(List<FilteredPerfumeDto> dtos) {
		List<Offer> offersToPersist = new ArrayList<>();
		for (FilteredPerfumeDto dto : dtos) {
			//entities to perfume
			Brand brand = brandService.findOrCreate(dto.getBrand());
			PerfumeType perfumeType = perfumeTypeService.findOrCreatePerfumeType(dto.getType());
			PerfumeVolume volume = perfumeVolumeService.findOrCreateVolume(dto.getVolume());
			
			//perfume name with brand
			Perfume perfume = perfumeService.findOrCreatePerfume(dto.getName(),brand);
			//perfume variant entity (volume and ptype (edt/edp))
			PerfumeVariant perfumeVariant = perfumeVariantService.findOrCreatePerfumeVariant(perfume, perfumeType, volume);
			
			//site
			Site site = siteService.createOrUpdateSite(dto.getSite());
			//offer entity - perfumeId, site, url- if perfumeid&&site exist just create timecheck
			Offer offer = offerService.createOrUpdateOffer(dto, perfumeVariant, site);
			
			//new price, send the offer if you need to get previous price
			Price price = priceService.createOrUpdate(convertToDouble(dto.getPrice()), offer);
			StockStatus stockStatus = stockStatusService.findOrCreate(dto.getStock());
			
			//offerstatus entity -
			//calls offerstatus service where it searches the offer id
			OfferStatus offerStatus = offerStatusService.findOrCreateOfferStatus(offer,price,stockStatus);
		}
	}
	
	private double convertToDouble(String priceStr) {
		Double value = conversionService.convert(priceStr, Double.class);
		return value != null ? value : 0.0;
	}
	
	private int convertToInteger(String percentStr) {
		Integer value = conversionService.convert(percentStr, Integer.class);
		return value != null ? value : 0;
	}
}