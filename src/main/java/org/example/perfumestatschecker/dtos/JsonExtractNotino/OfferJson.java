package org.example.perfumestatschecker.dtos.JsonExtractNotino;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class OfferJson {
	
	public String name;
	public String availability;
	public String price;
	public String priceCurrency;
	public String itemCountry;
	public String sku;
	public String url;
	public String image;
	
	public OfferJson() {
	}
	public OfferJson(String name, String availability, String price, String priceCurrency, String itemCountry, String sku, String url, String image) {
		this.name = name;
		this.availability = availability;
		this.price = price;
		this.priceCurrency = priceCurrency;
		this.itemCountry = itemCountry;
		this.sku = sku;
		this.url = url;
		this.image = image;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setPriceCurrency(String priceCurrency) {
		this.priceCurrency = priceCurrency;
	}
	
	public void setItemCountry(String itemCountry) {
		this.itemCountry = itemCountry;
	}
	
	public void setSku(String sku) {
		this.sku = sku;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAvailability() {
		return availability;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getPriceCurrency() {
		return priceCurrency;
	}
	
	public String getItemCountry() {
		return itemCountry;
	}
	
	public String getSku() {
		return sku;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getImage() {
		return image;
	}
}
