package org.example.perfumestatschecker.services.entityservices.priceservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.Offer;
import org.example.perfumestatschecker.models.Price;
import org.example.perfumestatschecker.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;

import static java.lang.Double.parseDouble;

@Service
public class PriceServiceImpl implements PriceService{
	
	private final PriceRepository priceRepository;
	
	@Autowired
	public PriceServiceImpl(PriceRepository priceRepository){
		this.priceRepository = priceRepository;
	}
	
	
	@Override
	@Transactional
	public Price createOrUpdatePrice(Offer offer, FilteredPerfumeDto dto){
		Price currentPrice = offer.getPrices().stream()
				.max(Comparator.comparing(Price::getId))
				.orElse(null);
		
		
		Double dtoPrice = parseDouble(dto.getPrice());
		if (currentPrice == null || !currentPrice.getPrice().equals(dtoPrice)) {
			// If there's no current price or the DTO's price is different, create/update
			Price newPrice = new Price();
			newPrice.setOffer(offer);
			newPrice.setPrice(dtoPrice);
			
			// discount, price per ml...
			//todo
			// here
			//newPrice.setPricePerMl(functionToCalculateIt)
			// ....
			
			// For simplicity, setting some values directly from DTO
			// -setting the discount if any...
			if(!(dto.getDiscount() == null)){
				newPrice.setDiscount(parseDouble((dto.getDiscount())));
			}
			
			priceRepository.save(newPrice);
			
			//update offer price list.
			offer.getPrices().add(newPrice);
			
			return newPrice;
		}
		
		// if current price matches the dto's price - return the current price without changes
		return currentPrice;
	}
}
