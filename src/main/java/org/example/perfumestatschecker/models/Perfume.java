package org.example.perfumestatschecker.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume")
public class Perfume {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//name of perfume
	@Column(name = "perfume_name")
	private String perfumeName;
	
	//brand name of perfume
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;
	
	//volume of perfume
	@ManyToOne
	@JoinColumn(name="volume_id")
	private PerfumeVolume volume;
	
	//type of perfume
	@ManyToOne
	@JoinColumn(name="type_id")
	private PerfumeType type;
	
	
	//offers of perfume
	@OneToMany(mappedBy = "perfume")
	private List<Offer> offers;
	
	public Perfume() {
	}
	
	public Perfume(String perfumeName, Brand brand, PerfumeVolume volume, PerfumeType type, List<Offer> offers) {
		this.perfumeName = perfumeName;
		this.brand = brand;
		this.volume = volume;
		this.type = type;
		this.offers = offers;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setPerfumeName(String perfumeName) {
		this.perfumeName = perfumeName;
	}
	
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public void setVolume(PerfumeVolume volume) {
		this.volume = volume;
	}
	
	public void setType(PerfumeType type) {
		this.type = type;
	}
	
	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getPerfumeName() {
		return perfumeName;
	}
	
	public Brand getBrand() {
		return brand;
	}
	
	public PerfumeVolume getVolume() {
		return volume;
	}
	
	public PerfumeType getType() {
		return type;
	}
	
	public List<Offer> getOffers() {
		return offers;
	}
}