package org.example.perfumestatschecker.models.account;


import jakarta.persistence.*;
import org.example.perfumestatschecker.models.perfume.Perfume;

@Entity
@Table(name = "perfume_wishlist")
public class PerfumeWishlist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "perfume_id")
	private Perfume perfume;
}
