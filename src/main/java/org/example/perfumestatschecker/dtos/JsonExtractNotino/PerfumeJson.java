package org.example.perfumestatschecker.dtos.JsonExtractNotino;

import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Offer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PerfumeJson {
	public Brand brand;
	public List<String> image;
	public List<Offer> offers;
	
	public PerfumeJson() {
	}
	
	public PerfumeJson(Brand brand, List<String> image, List<Offer> offers) {
		this.brand = brand;
		this.image = image;
		this.offers = offers;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public List<String> getImage() {
		return image;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public void setImage(List<String> image) {
		this.image = image;
	}
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}
