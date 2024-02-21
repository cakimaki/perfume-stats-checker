package org.example.perfumestatschecker.models.offer;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stock_status")
public class StockStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "status_name")
	private String name;
	
	@OneToMany(mappedBy = "stockStatus")
	private List<OfferStatus> offerStatuses = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<OfferStatus> getOfferStatuses() {
		return offerStatuses;
	}
	
	public void setOfferStatuses(List<OfferStatus> offerStatuses) {
		this.offerStatuses = offerStatuses;
	}
}
