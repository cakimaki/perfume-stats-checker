package org.example.perfumestatschecker.models.perfume;

import jakarta.persistence.*;
import org.example.perfumestatschecker.models.offer.Offer;

import java.util.List;

@Entity
@Table(name = "perfume")
public class Perfume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//name of perfume
	@ManyToOne
	@JoinColumn(name = "perfumename_id")
	private PerfumeName name;
	
	//brand name of perfume
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	//volume of perfume
	@ManyToOne
	@JoinColumn(name = "volume_id")
	private PerfumeVolume volume;
	
	//type of perfume
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PerfumeType type;
	
	//offers of perfume
	@OneToMany(mappedBy = "perfume")
	private List<Offer> offers;
	
	public Perfume() {
	}
	
	public Perfume(PerfumeName name, Brand brand, PerfumeVolume volume, PerfumeType type, List<Offer> offers) {
		this.name = name;
		this.brand = brand;
		this.volume = volume;
		this.type = type;
		this.offers = offers;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PerfumeName getName() {
		return name;
	}
	
	public void setName(PerfumeName name) {
		this.name = name;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public PerfumeVolume getVolume() {
		return volume;
	}
	
	public void setVolume(PerfumeVolume volume) {
		this.volume = volume;
	}
	
	public PerfumeType getType() {
		return type;
	}
	
	public void setType(PerfumeType type) {
		this.type = type;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
}