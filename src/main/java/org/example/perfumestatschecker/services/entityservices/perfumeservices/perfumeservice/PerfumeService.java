package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.models.perfume.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PerfumeService {
	@Transactional
	Perfume findOrCreatePerfume(PerfumeName perfumeName, Brand brand, PerfumeType type, PerfumeVolume volume);
	
	List<PerfumeDetailsDto> getAllPerfumesDetails();
}
