package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferStatusRepository extends JpaRepository<OfferStatus,Long> {
}
