package org.example.perfumestatschecker.dtos;

public class FilteredPerfumeDto {
	private String name;
	private String brand;
	private String type;
	private String volume;
	private String price;
	private String discount;
	private String url;
	private String site;
	private boolean stock;
	
	public FilteredPerfumeDto(){};
	
	public FilteredPerfumeDto(String name, String brand, String type, String volume, String price, String discount, String url, boolean stock) {
		this.name = name;
		this.brand = brand;
		this.type = type;
		this.volume = volume;
		this.price = price;
		this.discount = discount;
		this.url = url;
		this.stock = stock;
	}
	
	public boolean isStock() {
		return stock;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	public String getName() {
		return name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public String getType() {
		return type;
	}
	
	public String getVolume() {
		return volume;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getDiscount() {
		return discount;
	}
	
	public String getUrl() {
		return url;
	}
	
	public boolean getStock() {
		return stock;
	}
	
	@Override
	public String toString() {
		return "FilteredPerfumeDto{" +
				"name='" + name + '\'' +
				", brand='" + brand + '\'' +
				", type='" + type + '\'' +
				", volume='" + volume + '\'' +
				", price='" + price + '\'' +
				", discount='" + discount + '\'' +
				", url='" + url + '\'' +
				", stock='" + stock + '\'' +
				'}';
	}
}