package org.example.perfumestatschecker.dtos.JsonExtractNotino;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Offer;
import org.springframework.core.style.ToStringCreator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@JsonIgnoreProperties(ignoreUnknown = true)
public class PerfumeJson {
	public BrandJson brand;
	public List<String> image;
	public List<OfferJson> offers;
	
	public PerfumeJson() {
	}
	
	public PerfumeJson(BrandJson brand, List<String> image, List<OfferJson> offers) {
		this.brand = brand;
		this.image = image;
		this.offers = offers;
	}
	
	public void setBrand(BrandJson brand) {
		this.brand = brand;
	}
	
	public void setImage(List<String> image) {
		this.image = image;
	}
	
	public void setOffers(List<OfferJson> offers) {
		this.offers = offers;
	}
	
	public BrandJson getBrand() {
		return brand;
	}
	
	public List<String> getImage() {
		return image;
	}
	
	public List<OfferJson> getOffers() {
		return offers;
	}
	
	@Override
	public String toString() {
		return "PerfumeJson{" +
				"brand=" + brand +
				", image=" + image +
				", offers=" + offers +
				'}';
	}
}
