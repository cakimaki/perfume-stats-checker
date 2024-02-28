package org.example.perfumestatschecker.models.account;

import jakarta.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private User user;
}
