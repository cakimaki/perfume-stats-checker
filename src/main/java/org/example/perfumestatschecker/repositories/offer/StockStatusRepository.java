package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockStatusRepository extends JpaRepository<StockStatus,Long> {
	Optional<StockStatus> findByName(String name);
}
