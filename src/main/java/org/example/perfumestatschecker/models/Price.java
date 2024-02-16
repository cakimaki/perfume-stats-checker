package org.example.perfumestatschecker.models;

import jakarta.persistence.*;

@Entity
@Table(name = "price")
public class Price {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@MapsId
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
}
