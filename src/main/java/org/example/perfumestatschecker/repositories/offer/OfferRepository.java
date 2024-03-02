package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.dtos.getdtos.OfferProjectionDto;
import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.Site;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer,Long> {
	@Query("SELECT o from Offer o WHERE o.perfumeVariant = :perfumeVariant AND o.site = :site AND o.offerUrl = :offerUrl" )
	Optional<Offer> findByPerfumeVariantAndSiteAndOfferUrl(@Param("perfumeVariant") PerfumeVariant perfumeVariant, @Param("site") Site site, @Param("offerUrl") String offerUrl);
	
	@Query("SELECT s.name as site, o.offerUrl as offerUrl, p.name as perfumeName, b.name as brandName, " +
			"pt.name as perfumeType, v.name as volume, pr.price as price, pr.discountPercent as discountPercent," +
			"pr.lastPrice as lastPrice, pr.percentDifferenceFromLastPrice as percentDifferenceFromLastPrice," +
			"ss.name as stockStatus, os.firstTimeOfCheck as firstTimeOfCheck, os.lastTimeOfCheck as lastTimeOfCheck " +
			"FROM Offer o " +
			"JOIN o.perfumeVariant pv " +
			"JOIN pv.perfume p " +
			"JOIN p.brand b " +
			"JOIN pv.type pt " +
			"JOIN pv.volume v " +
			"JOIN o.site s " +
			"JOIN o.offerStatuses os " +
			"JOIN os.price pr " +
			"JOIN os.stockStatus ss " +
			"WHERE os.lastStatus = true")
	List<OfferProjectionDto> findOfferDetailsWithLastStatus();
	
	@Query("SELECT s.name as site, o.offerUrl as offerUrl, p.name as perfumeName, b.name as brandName, " +
			"pt.name as perfumeType, v.name as volume, pr.price as price, pr.discountPercent as discountPercent," +
			"pr.lastPrice as lastPrice, pr.percentDifferenceFromLastPrice as percentDifferenceFromLastPrice," +
			"ss.name as stockStatus, os.firstTimeOfCheck as firstTimeOfCheck, os.lastTimeOfCheck as lastTimeOfCheck " +
			"FROM Offer o " +
			"JOIN o.perfumeVariant pv " +
			"JOIN pv.perfume p " +
			"JOIN p.brand b " +
			"JOIN pv.type pt " +
			"JOIN pv.volume v " +
			"JOIN o.site s " +
			"JOIN o.offerStatuses os " +
			"JOIN os.price pr " +
			"JOIN os.stockStatus ss " +
			"WHERE os.lastStatus = true AND p.id = :id")
	List<OfferProjectionDto> findOfferDetailsByPerfumeId(Long id);
	
	@Query("SELECT s.name as site, o.offerUrl as offerUrl, p.name as perfumeName, b.name as brandName, " +
			"pt.name as perfumeType, v.name as volume, pr.price as price, pr.discountPercent as discountPercent," +
			"pr.lastPrice as lastPrice, pr.percentDifferenceFromLastPrice as percentDifferenceFromLastPrice," +
			"ss.name as stockStatus, os.firstTimeOfCheck as firstTimeOfCheck, os.lastTimeOfCheck as lastTimeOfCheck " +
			"FROM Offer o " +
			"JOIN o.perfumeVariant pv " +
			"JOIN pv.perfume p " +
			"JOIN  p.brand b " +
			"JOIN pv.type pt " +
			"JOIN pv.volume v " +
			"JOIN o.site s " +
			"JOIN o.offerStatuses os " +
			"JOIN os.price pr " +
			"JOIN os.stockStatus ss " +
			"WHERE os.lastStatus = true AND p.name = :name")
	List<OfferProjectionDto> findOfferDetailsByPerfumeName(String name);
}
