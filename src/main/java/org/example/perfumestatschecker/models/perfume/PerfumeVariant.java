package org.example.perfumestatschecker.models.perfume;

import jakarta.persistence.*;
import org.example.perfumestatschecker.models.offer.Offer;

import java.util.List;

@Entity
@Table(name = "perfume_variant")
public class PerfumeVariant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//name of perfume
	
	@ManyToOne
	@JoinColumn(name = "perfumename_id")
	private Perfume perfume;
	

	//volume of perfume
	@ManyToOne
	@JoinColumn(name = "volume_id")
	private PerfumeVolume volume;
	
	//type of perfume
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PerfumeType type;
	
	//offers of perfume
	@OneToMany(mappedBy = "perfumeVariant")
	private List<Offer> offers;
	
	public PerfumeVariant() {
	}
	
	
	public PerfumeVariant(Long id, Perfume perfume, PerfumeVolume volume, PerfumeType type, List<Offer> offers) {
		this.id = id;
		this.perfume = perfume;
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
	
	public Perfume getPerfume() {
		return perfume;
	}
	
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
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