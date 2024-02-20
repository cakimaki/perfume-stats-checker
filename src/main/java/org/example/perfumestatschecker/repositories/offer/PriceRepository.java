package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
