package org.example.perfumestatschecker.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "perfume_volume")
public class PerfumeVolume {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "volume")
	private String volume;
	
	@OneToMany(mappedBy = "volume")
	private List<Perfume> perfumes;
}
