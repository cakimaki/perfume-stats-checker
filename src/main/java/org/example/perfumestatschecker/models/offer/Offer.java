package org.example.perfumestatschecker.models.offer;


import jakarta.persistence.*;
import org.example.perfumestatschecker.models.perfume.Perfume;

import java.util.ArrayList;
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
	
	@OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OfferStatus> offerStatuses = new ArrayList<>();
	
	@Column(name = "site")
	private String site;
	
	@Column(name = "url_to_offer")
	private String offerUrl;
	
	@Column(name = "url_to_image")
	private String imageUrl;
	
	
	public Offer(){}
	
	public Perfume getPerfume() {
		return perfume;
	}
	
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	
	public List<OfferStatus> getOfferStatuses() {
		return offerStatuses;
	}
	
	public void setOfferStatuses(List<OfferStatus> offerStatuses) {
		this.offerStatuses = offerStatuses;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
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
