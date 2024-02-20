package org.example.perfumestatschecker.models.offer;


import jakarta.persistence.*;

@Entity
@Table(name = "stock_status")
public class StockStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "status_name")
	private String name;
	
}
