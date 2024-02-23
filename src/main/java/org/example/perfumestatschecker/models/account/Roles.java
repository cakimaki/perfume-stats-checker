package org.example.perfumestatschecker.models.account;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
}
