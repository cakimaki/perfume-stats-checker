package org.example.perfumestatschecker.models;

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
	@JoinColumn(name= "price_id")
	private Price price;
	public TimeChecked() {
	}
	
	public LocalDateTime getTime() {
		return time;
	}
	
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
}
