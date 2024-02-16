package org.example.perfumestatschecker.dtos.JsonExtractNotino;

import org.example.perfumestatschecker.models.Brand;
import org.example.perfumestatschecker.models.Offer;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OfferJson {
	
	public String name;
	public String availability;
	public double price;
	public String priceCurrency;
	public String itemCountry;
	public String sku;
	public String url;
	public String image;
	
	// Method to extract volume from name
	public Integer getVolumeInMl() {
		// Assuming the volume is always at the end of the name and followed by "мл."
		Pattern pattern = Pattern.compile("(\\d+) мл\\.");
		Matcher matcher = pattern.matcher(this.name);
		if (matcher.find()) {
			return Integer.parseInt(matcher.group(1));
		}
		return null;
	}
	public OfferJson() {
	}
	public OfferJson(String name, String availability, double price, String priceCurrency, String itemCountry, String sku, String url, String image) {
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
	
	public void setPrice(double price) {
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
	
	public double getPrice() {
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
