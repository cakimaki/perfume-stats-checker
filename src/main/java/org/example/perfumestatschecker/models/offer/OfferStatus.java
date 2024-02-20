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
	
	@OneToMany(mappedBy = "offerStatus")
	private List<TimeChecked> timeCheckeds = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "price_id")
	private Price price;
	
	@ManyToOne
	@JoinColumn(name= "stock_id")
	private StockStatus stockStatus;
	
	
}
