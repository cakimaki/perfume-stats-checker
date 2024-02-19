package org.example.perfumestatschecker.services.entityservices.perfumetypeservice;

import org.example.perfumestatschecker.models.PerfumeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfumeTypeService{
	
	PerfumeType findOrCreatePerfumeType(String PerfumeType);
}
