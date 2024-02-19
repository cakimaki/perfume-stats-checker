package org.example.perfumestatschecker.models;


import jakarta.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
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
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Price> prices = new ArrayList<>();
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "in_stock")
	private boolean inStock;
	
	@Column(name = "url_to_offer")
	private String offerUrl;
	
	@Column(name = "url_to_image")
	private String imageUrl;
	
	
	public Offer(){}
	
	public Perfume getPerfume() {
		return perfume;
	}
	
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	
	public List<Price> getPrices() {
		return prices;
	}
	
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public boolean isInStock() {
		return inStock;
	}
	
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	
	public String getOfferUrl() {
		return offerUrl;
	}
	
	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
