package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer,Long> {
	@Query("SELECT o from Offer o WHERE o.perfume = :perfume AND o.site = :site AND o.offerUrl = :offerUrl" )
	Optional<Offer> findByPerfumeAndSiteAndOfferUrl(@Param("perfume")Perfume perfume,@Param("site") String site,@Param("offerUrl") String offerUrl);
}
