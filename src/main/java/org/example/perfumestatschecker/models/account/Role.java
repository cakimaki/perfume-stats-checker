package org.example.perfumestatschecker.models.account;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "role_name")
	private String name;
	
	@OneToMany(mappedBy = "role")
	private List<UserRole> userRoles = new ArrayList<>();
	
}
