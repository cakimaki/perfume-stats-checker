package org.example.perfumestatschecker.services.entityservices.offerservice.priceservice;

import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.repositories.offer.OfferStatusRepository;
import org.example.perfumestatschecker.repositories.offer.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{
	
	private final PriceRepository priceRepository;
	private final OfferStatusRepository offerStatusRepository;
	@Autowired
	public PriceServiceImpl(PriceRepository priceRepository, OfferStatusRepository offerStatusRepository){
		this.priceRepository = priceRepository;
		this.offerStatusRepository = offerStatusRepository;
	}
	
	@Transactional
	@Override
	public Price createOrUpdate(Double priceNumber, Offer offer){
		Optional<Price> priceOpt = priceRepository.findByPrice(priceNumber);
		
		if(priceOpt.isPresent()){
			return priceOpt.get();
		}else{
			Price price = new Price();
			price.setPrice(priceNumber);
			price.setPricePerMl(calculatePricePer1Ml(priceNumber,offer.getPerfumeVariant().getVolume().getName()));
			//find the existing offer and set lastPrice in the new
			OfferStatus offerStatus = offerStatusRepository.findOfferStatusByOfferAndLastStatusTrue(offer);
			if(offerStatus != null) {
				price.setLastPrice(offerStatus.getPrice().getPrice());
				price.setPercentDifferenceFromLastPrice(calculatePercentDifferenceFromLastPrice(price.getPrice(),price.getLastPrice()));
			}
			return priceRepository.save(price);
		}
	}
	
	public Double calculatePricePer1Ml(Double price, String ml){
		return price / Double.parseDouble(ml);
	}
	public Integer calculatePercentDifferenceFromLastPrice(Double newprice, Double lastprice){
		return (Integer) (int) (((newprice*100)/ lastprice) -100);
	}
	/*@Override
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
	}*/
}
