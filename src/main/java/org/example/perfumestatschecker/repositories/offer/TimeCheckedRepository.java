package org.example.perfumestatschecker.repositories.offer;

import org.example.perfumestatschecker.models.offer.TimeOfCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeCheckedRepository extends JpaRepository<TimeOfCheck, Long> {



}