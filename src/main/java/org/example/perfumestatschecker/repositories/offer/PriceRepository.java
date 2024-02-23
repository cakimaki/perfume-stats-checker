package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PriceRepository extends JpaRepository<Price,Long> {
	
	Optional<Price> findByPrice(Double price);
	
}
