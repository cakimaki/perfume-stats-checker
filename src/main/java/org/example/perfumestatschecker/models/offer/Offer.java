package org.example.perfumestatschecker.models.offer;


import jakarta.persistence.*;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeVariant;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offer")
public class Offer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "perfume_variant_id")
	private PerfumeVariant perfumeVariant;
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OfferStatus> offerStatuses = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "site_id")
	private Site site;
	
	@Column(name = "url_to_offer")
	private String offerUrl;
	
	@Column(name = "url_to_image")
	private String imageUrl;
	
	
	public Offer(){}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PerfumeVariant getPerfumeVariant() {
		return perfumeVariant;
	}
	
	public void setPerfumeVariant(PerfumeVariant perfumeVariant) {
		this.perfumeVariant = perfumeVariant;
	}
	
	public List<OfferStatus> getOfferStatuses() {
		return offerStatuses;
	}
	
	public void setOfferStatuses(List<OfferStatus> offerStatuses) {
		this.offerStatuses = offerStatuses;
	}
	
	public Site getSite() {
		return site;
	}
	
	public void setSite(Site site) {
		this.site = site;
	}
	
	public String getOfferUrl() {
		return offerUrl;
	}
	
	public void setOfferUrl(String offerUrl) {
		this.offerUrl = offerUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
