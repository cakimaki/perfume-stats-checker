package org.example.perfumestatschecker.models.offer;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="offer_status")
public class OfferStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "last_status")
	private boolean lastStatus;
	
	@OneToMany(mappedBy = "offerStatus")
	private List<TimeOfCheck> timeOfChecks = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "price_id")
	private Price price;
	
	@ManyToOne
	@JoinColumn(name= "stock_id")
	private StockStatus stockStatus;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<TimeOfCheck> getTimeOfChecks() {
		return timeOfChecks;
	}
	
	public void setTimeOfChecks(List<TimeOfCheck> timeOfChecks) {
		this.timeOfChecks = timeOfChecks;
	}
	
	public boolean isLastStatus() {
		return lastStatus;
	}
	
	public void setLastStatus(boolean lastStatus) {
		this.lastStatus = lastStatus;
	}
	
	public List<TimeOfCheck> getTimeCheckeds() {
		return timeOfChecks;
	}
	
	public void setTimeCheckeds(List<TimeOfCheck> timeOfChecks) {
		this.timeOfChecks = timeOfChecks;
	}
	
	public Offer getOffer() {
		return offer;
	}
	
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public Price getPrice() {
		return price;
	}
	
	public void setPrice(Price price) {
		this.price = price;
	}
	
	public StockStatus getStockStatus() {
		return stockStatus;
	}
	
	public void setStockStatus(StockStatus stockStatus) {
		this.stockStatus = stockStatus;
	}
}
