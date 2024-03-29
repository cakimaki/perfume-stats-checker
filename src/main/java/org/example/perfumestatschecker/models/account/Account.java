package org.example.perfumestatschecker.models.account;


import jakarta.persistence.*;

@Entity
@Table(name= "account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "last_update")
	private boolean lastUpdate;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "second_name")
	private String secondName;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
}
