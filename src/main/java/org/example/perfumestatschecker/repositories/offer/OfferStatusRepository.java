package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.Offer;
import org.example.perfumestatschecker.models.offer.OfferStatus;
import org.example.perfumestatschecker.models.offer.Price;
import org.example.perfumestatschecker.models.offer.StockStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OfferStatusRepository extends JpaRepository<OfferStatus, Long> {
	@Query("SELECT os FROM OfferStatus os WHERE os.offer =:offer AND os.price =:price AND os.stockStatus =:stock AND os.lastStatus = true")
	Optional<OfferStatus> findByOfferAndPriceAndStock(@Param("offer") Offer offer, @Param("price") Price price, @Param("stock") StockStatus stock);
	
	List<OfferStatus> findAllByOfferAndLastStatusTrue(Offer offer);
	
	@Query("SELECT os FROM OfferStatus os WHERE os.offer = :offer AND os.lastStatus = true")
	OfferStatus findOfferStatusByOfferAndLastStatusTrue(Offer offer);
}
