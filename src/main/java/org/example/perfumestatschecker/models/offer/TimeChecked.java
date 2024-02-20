package org.example.perfumestatschecker.models.offer;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "timechecked")
public class TimeChecked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name= "time_of_check")
	private LocalDateTime time;
	
	@ManyToOne
	@JoinColumn(name= "timechecked_id")
	private OfferStatus offerStatus;
	
	public TimeChecked() {
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
