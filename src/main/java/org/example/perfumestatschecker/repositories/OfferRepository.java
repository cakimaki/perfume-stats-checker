package org.example.perfumestatschecker.repositories;

import org.example.perfumestatschecker.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer,Long> {
}
