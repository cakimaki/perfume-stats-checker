package org.example.perfumestatschecker.models.offer;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "price")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "discount_percent")
	private Integer discountPercent;
	
	@Column (name = "discount")
	private Double discount;
	
	@Column(name = "price_without_discount")
	private Double priceWithoutDiscount;
	
	@Column(name = "price_per_ml")
	private Double pricePerMl;
	
	@Column(name = "last_price")
	private Double lastPrice;
	
	@Column(name = "percent_difference_from_last_price")
	private Integer percentDifferenceFromLastPrice;
	
	@OneToMany(mappedBy = "price")
	private List<OfferStatus> offerStatuses = new ArrayList<>();
	
	
	public Price(){
	
	}
	
	public Price(Double price){
	
	}
	public Price(Double price, Integer discountPercent){
	
	}
	
	public Double getLastPrice() {
		return lastPrice;
	}
	
	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}
	
	public Integer getPercentDifferenceFromLastPrice() {
		return percentDifferenceFromLastPrice;
	}
	
	public void setPercentDifferenceFromLastPrice(Integer percentDifferenceFromLastPrice) {
		this.percentDifferenceFromLastPrice = percentDifferenceFromLastPrice;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<OfferStatus> getOfferStatuses() {
		return offerStatuses;
	}
	
	public void setOfferStatuses(List<OfferStatus> offerStatuses) {
		this.offerStatuses = offerStatuses;
	}
	
	
	public Double getPrice() {
		return price;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Integer getDiscountPercent() {
		return discountPercent;
	}
	
	public void setDiscountPercent(Integer discountPercent) {
		this.discountPercent = discountPercent;
	}
	
	public Double getDiscount() {
		return discount;
	}
	
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public Double getPriceWithoutDiscount() {
		return priceWithoutDiscount;
	}
	
	public void setPriceWithoutDiscount(Double priceWithoutDiscount) {
		this.priceWithoutDiscount = priceWithoutDiscount;
	}
	
	public Double getPricePerMl() {
		return pricePerMl;
	}
	
	public void setPricePerMl(Double pricePerMl) {
		this.pricePerMl = pricePerMl;
	}
}
