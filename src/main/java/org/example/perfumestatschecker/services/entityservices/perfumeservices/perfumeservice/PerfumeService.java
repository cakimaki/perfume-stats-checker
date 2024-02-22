package org.example.perfumestatschecker.services.entityservices.perfumeservices.perfumeservice;

import org.example.perfumestatschecker.dtos.getdtos.PerfumeDetailsDto;
import org.example.perfumestatschecker.models.perfume.Brand;
import org.example.perfumestatschecker.models.perfume.Perfume;
import org.example.perfumestatschecker.models.perfume.PerfumeType;
import org.example.perfumestatschecker.models.perfume.PerfumeVolume;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PerfumeService {
	@Transactional
	Perfume findOrCreatePerfume(String name, Brand brand, PerfumeType type, PerfumeVolume volume);
	
	List<PerfumeDetailsDto> getAllPerfumesDetails();
}
