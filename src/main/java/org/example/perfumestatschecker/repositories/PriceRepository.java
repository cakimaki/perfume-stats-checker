package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
