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
}
