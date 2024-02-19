package org.example.perfumestatschecker.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "price")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "discount_percent")
	private Integer discountPercent;
	
	@Column (name = "discount")
	private Double discount;
	
	@Column(name = "price_without_discount")
	private Double priceWithoutDiscount;
	
	@Column(name = "price_per_ml")
	private Integer pricePerMl;
	
	@OneToMany(mappedBy = "price")
	private List<TimeChecked> timeChecked = new ArrayList<>();
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public List<TimeChecked> getTimeChecked() {
		return timeChecked;
	}
	
	public void setTimeChecked(List<TimeChecked> timeChecked) {
		this.timeChecked = timeChecked;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
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
	
	public Integer getPricePerMl() {
		return pricePerMl;
	}
	
	public void setPricePerMl(Integer pricePerMl) {
		this.pricePerMl = pricePerMl;
	}
}
