package org.example.perfumestatschecker.repositories.account;

import org.example.perfumestatschecker.models.account.PerfumeWishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeWishlistRepository extends JpaRepository<PerfumeWishlist, Long> {
}
