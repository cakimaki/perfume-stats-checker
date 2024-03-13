package org.example.perfumestatschecker.dtos.getdtos;

import java.time.LocalDateTime;

public interface OfferProjectionDto {
	String getPerfumeName();
	
	String getBrandName();
	
	String getPerfumeType();
	
	String getVolume();
	
	String getSite();
	
	String getOfferUrl();
	
	Double  getPrice();
	
	Integer getDiscountPercent();
	
	Double  getLastPrice();
	
	Integer getPercentDifferenceFromLastPrice();
	
	String getStockStatus();
	
	LocalDateTime getFirstTimeOfCheck();
	
	LocalDateTime getLastTimeOfCheck();
	
	Double getPricePerMl();
	
	
}
