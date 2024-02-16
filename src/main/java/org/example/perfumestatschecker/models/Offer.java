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
}
