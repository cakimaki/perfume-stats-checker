package org.example.perfumestatschecker.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "time_checked")
public class TimeChecked {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "time")
	private LocalDateTime time;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
}
