package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockStatusRepository extends JpaRepository<StockStatus,Long> {
}
