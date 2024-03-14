package org.example.perfumestatschecker.services.entityservices.offerservice.priceservice;

import org.example.perfumestatschecker.dtos.FilteredPerfumeDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.repositories.offer.OfferStatusRepository;
import org.example.perfumestatschecker.repositories.offer.PriceRepository;
import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService{
	
	private final PriceRepository priceRepository;
	private final OfferStatusRepository offerStatusRepository;
	private final ConversionService conversionService;
	@Autowired
	public PriceServiceImpl(PriceRepository priceRepository, OfferStatusRepository offerStatusRepository, ConversionService conversionService){
		this.priceRepository = priceRepository;
		this.offerStatusRepository = offerStatusRepository;
		this.conversionService = conversionService;
	}
	
	@Transactional
	@Override
	public Price createOrUpdate(FilteredPerfumeDto dto, Offer offer){
		Double priceNumber = convertToDouble(dto.getPrice());
		if(priceNumber == 0){
			throw new NoSuchElementException("Fetched price is 0?");
		}
		
		Optional<Price> priceOpt = priceRepository.findByPrice(priceNumber);
		
		if(priceOpt.isPresent()){
			return priceOpt.get();
		}else{
			Price price = new Price();
			price.setPrice(priceNumber);
			price.setPriceStamp(LocalDateTime.now());
			if(!offer.getPerfumeVariant().getVolume().getName().isEmpty()) {
				price.setPricePerMl(calculatePricePer1Ml(priceNumber, offer.getPerfumeVariant().getVolume().getName()));
			}
			if(dto.getDiscountedPrice()!=null && !dto.getDiscountedPrice().equals("")){
					double priceWoDiscount = convertToDouble(dto.getDiscountedPrice());
					price.setDiscountPercent(calculatePercentDifferenceFromLastPrice(priceNumber,priceWoDiscount));
					price.setDiscount(priceNumber-priceWoDiscount);
					price.setPriceWithoutDiscount(convertToDouble(dto.getDiscountedPrice()));
			}
			
			//find the existing offer and set lastPrice in the new
			OfferStatus offerStatus = offerStatusRepository.findOfferStatusByOfferAndLastStatusTrue(offer);
			System.out.println(offer);
			if(offerStatus != null) {
				price.setLastPrice(offerStatus.getPrice().getPrice());
				price.setPercentDifferenceFromLastPrice(calculatePercentDifferenceFromLastPrice(price.getPrice(),price.getLastPrice()));
			}
			return priceRepository.save(price);
		}
	}
	
	private double convertToDouble(String priceStr) {
		Double value = conversionService.convert(priceStr, Double.class);
		return value != null ? value : 0.0;
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
