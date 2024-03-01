package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeVariantDetailsDto;
import org.example.perfumestatschecker.models.perfume.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PerfumeVariantService {
	@Transactional
	PerfumeVariant findOrCreatePerfumeVariant(Perfume perfume, PerfumeType type, PerfumeVolume volume);
	

	List<PerfumeVariantDetailsDto> getAllPerfumeVariantsDetails();
}
