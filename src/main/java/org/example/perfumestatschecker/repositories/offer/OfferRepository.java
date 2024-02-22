package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer,Long> {
	@Query("SELECT o from Offer o WHERE o.perfume = :perfume AND o.site = :site AND o.offerUrl = :offerUrl" )
	Optional<Offer> findByPerfumeAndSiteAndOfferUrl(@Param("perfume")Perfume perfume,@Param("site") String site,@Param("offerUrl") String offerUrl);
	
	@Query("SELECT o.site as site, o.offerUrl as offerUrl, p.name as perfumeName, b.name as brandName, " +
			"pt.name as perfumeType, v.name as volume, pr.price as price, pr.discountPercent as discountPercent," +
			"pr.lastPrice as lastPrice, pr.percentDifferenceFromLastPrice as percentDifferenceFromLastPrice," +
			"ss.name as stockStatus, os.firstTimeOfCheck as firstTimeOfCheck, os.lastTimeOfCheck as lastTimeOfCheck " +
			"FROM Offer o JOIN o.perfume p JOIN  p.brand b JOIN p.type pt JOIN p.volume v JOIN o.offerStatuses os " +
			"JOIN os.price pr JOIN os.stockStatus ss WHERE os.lastStatus = true")
	List<OfferProjectionDto> findOfferDetailsWithLastStatus();
}
