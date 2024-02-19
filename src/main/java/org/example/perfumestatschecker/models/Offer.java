package org.example.perfumestatschecker.models;


import jakarta.persistence.*;

import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "perfume_id")
	private Perfume perfume;
	
	@OneToOne(mappedBy = "offer", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Price price;
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "in_stock")
	private boolean inStock;
	
	@Column(name = "url_to_offer")
	private String offerUrl;
	
	@Column(name = "url_to_image")
	private String imageUrl;
	
	@OneToMany(mappedBy = "offer")
	private List<TimeChecked> timeChecked;
	
	public Offer(){}
	
	public Offer(Perfume perfume, Price price, String site,
	             boolean inStock, String offerUrl, String imageUrl,
	             List<TimeChecked> timeChecked) {
		this.perfume = perfume;
		this.price = price;
		this.site = site;
		this.inStock = inStock;
		this.offerUrl = offerUrl;
		this.imageUrl = imageUrl;
		this.timeChecked = timeChecked;
	}
	
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public void setTimeChecked(List<TimeChecked> timeChecked) {
		this.timeChecked = timeChecked;
	}
	
	public Long getId() {
		return id;
	}
	
	public Perfume getPerfume() {
		return perfume;
	}
	
	public Price getPrice() {
		return price;
	}
	
	public String getSite() {
		return site;
	}
	
	public boolean isInStock() {
		return inStock;
	}
	
	public String getOfferUrl() {
		return offerUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public List<TimeChecked> getTimeChecked() {
		return timeChecked;
	}
}
