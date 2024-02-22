package org.example.perfumestatschecker.models.offer;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_of_checked")
public class TimeOfCheck {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "time_of_check")
	private LocalDateTime time;
	
	@ManyToOne
	@JoinColumn(name= "offer_status_id")
	private OfferStatus offerStatus;
	
	public TimeOfCheck() {
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public OfferStatus getOfferStatus() {
		return offerStatus;
	}
	
	public void setOfferStatus(OfferStatus offerStatus) {
		this.offerStatus = offerStatus;
	}
}
