package org.example.perfumestatschecker.dtos.siteextractions.JsonExtractNotino;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PerfumeJson {
	public BrandJson brand;
	public List<String> image;
	public List<OfferJson> offers;
	
	public String category;
	
	@JsonProperty("@id")
	public String id;
	
	public PerfumeJson() {
	}
	
	public PerfumeJson(BrandJson brand, List<String> image, List<OfferJson> offers) {
		this.brand = brand;
		this.image = image;
		this.offers = offers;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
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
